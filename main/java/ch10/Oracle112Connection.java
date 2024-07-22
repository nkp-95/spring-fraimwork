package ch10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Oracle112Connection {

	public static void main(String[] args) {
		//1.	JDBC_DRIVER 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDiver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//2.	데이터베이스 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "1234";
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Oracle 11.2 연결 성공!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Oracle 11.2 연결 실패!");
			return;
		}
		
		//3. db작업(select , insert, update, delete)
		try(Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM EMP")){
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				int deptno = rs.getInt("deptno");
				System.out.println("사원번호: " + empno + ", 이름: " + ename + ", 부서번호: " + deptno);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
