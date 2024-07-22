package ch12;

import java.util.HashMap;
import java.util.Map;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class RestConfig extends Application{
	public Map<String, Object>getProperties(){
		Map<String, Object> properties = new HashMap<String, Object>();
		
		properties.put("jersey.config.server,provider.packages", "ch12");  //jersey 타입으로 ch12 읽어옴(패키지)
		return properties;	//if 필요없이 맵구조로 키값 읽어옴(속도)[새로 생길때마다 맵에 넣어놓음]
	}
}
