package ch12;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/test")
public class RestApiExample {
	//겟방식 테스트할때 /jwbook/api/test
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello API Service";
	}
	
	//포스트 방식 테스트할때 - POSTMAN 에서
	//   http://localhost:8090/jwbook/api/test?msg=JAVA Web =>하면 나옴
	
	//from method = "post" action="/jwbook/news.nhn?action=addNews"
				//			(@QueryParam("action") String action)   
	@POST
	public String sayHello(@QueryParam("msg") String msg) {  //@QueryParam  => ?msg=JAVA Web <= 메서드 뒤에 있으면 @QueryParam으로 가져옴
						//request 없어도 가져올수 있음
		return msg + " POST API Service";
	}
	
}
