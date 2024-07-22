package ch12;

import java.sql.SQLException;
import java.util.List;

import ch10.News;
import ch10.NewsDAO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/news")
public class NewsApiService {
	NewsDAO dao;
	public NewsApiService(){
		dao = new NewsDAO();
	}
	
	//뉴스 등록
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String addNews(News news) {
		try {
			dao.addNews(news);
		} catch (Exception e) {
			e.printStackTrace();
			return "News API : 뉴스등록 실패";
		}
		return "News API : 뉴스 등록됨";
	}
	
	//뉴스 삭제
	@DELETE
	@Path("{aid}")
	public String deNews(@PathParam("aid")int aid) {
		try {
			dao.delNews(aid);
		} catch (SQLException e) {
			e.printStackTrace();
			return "News API: 뉴스 삭제 실패!! - " + aid;
		}
		
		return "News API: 뉴스 삭제 됨!! - " + aid;
	}
	
	//뉴스 목록 조회
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<News> getNewsList(){
		List<News> newsList = null;
		
		try {
			newsList = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newsList;
	}
	
	//뉴스 상세 정보
	@GET
	@Path("{aid}")
	@Produces(MediaType.APPLICATION_JSON)
	public News getNews(@PathParam("aid")int aid) {
		News news = null;
		
		try {
			news = dao.getNews(aid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return news;
	}
	
	
}
