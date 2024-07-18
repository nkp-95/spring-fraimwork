package ch10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDAO {
	final String JDBC_DRIVER = "org.h2.Driver";
	final String JDBC_URL = "jdbc:h2:tcp://localhost/~/jwbookdb";
	//DB 연결을 가져오는 메서드
	public Connection open() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL,"jwbook", "1234");
;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//News 목록 전체를 가지고 오기위한 메서드
	public List<News> getAll() throws Exception{
		Connection conn = open();
		
		List<News>newsList = new ArrayList<>();
		
		String sql = "select aid, title, FORMATDATETIME(date, 'yyyy-MM--dd hh:mm:ss') as cdate,";
		sql = sql + "img, content from news";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		try(conn; pstmt; rs){
			while(rs.next()) {
				News n = new News();
				n.setAid(rs.getInt("aid"));
				n.setTitle(rs.getString("title"));
				n.setDate(rs.getString("cdate"));
				n.setImg(rs.getString("img"));
				n.setContent(rs.getString("content"));
				
				newsList.add(n);
			}
			return newsList;
		}
	}
	
	//News 세부 내용 조회 : 목록 링크를 클릭했을때
	public News getNews(int aid) throws SQLException{
		Connection conn = open();
		
		News n = new News();
		
		String sql = "select aid, title, FORMATDATETIME(date, 'yyyy-MM--dd hh:mm:ss') as cdate,";
		sql = sql + "img, content from news where aid = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, aid);
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		
		try(conn; pstmt; rs){
			
			n.setAid(rs.getInt("aid"));
			n.setTitle(rs.getString("title"));
			n.setDate(rs.getString("cdate"));
			n.setImg(rs.getString("img"));
			n.setContent(rs.getString("content"));
			
			return n;
		}
	}
	
	//뉴스를 추가하는 메서드 인자로 DO 클래스인 News 타입을 받아 sql 완성
	public void addNews(News n) throws Exception{
		Connection conn = open();
		
		String sql = "insert into news(title, img, date, content)";
		sql += " values(?,?,current_timestemp(),?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn; pstmt){
			pstmt.setString(1, n.getTitle());
			pstmt.setString(2, n.getImg());
			pstmt.setString(3, n.getContent());
			pstmt.executeUpdate();
		}
	}
	
	//뉴스 삭제를 위한 메서드, 삭제할 뉴스의 aid를 받아 삭제한다.
	public void delNews(int aid) throws SQLException{
		Connection conn = open();
		String sql = "delete from news where aid = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn; pstmt){
			pstmt.setInt(1, aid);
			//삭제된 뉴스 기사가 없을 경우
			if(pstmt.executeUpdate() == 0) {
				throw new SQLException("DB에러");
			}
		}
		
	}
}