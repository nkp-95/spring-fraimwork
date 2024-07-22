package ch12;

import java.sql.SQLException;
import java.util.List;

import ch09.Product;
import ch09.productDAO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/Product")
public class ProductApiService {
	
	productDAO dao;
	
	public ProductApiService() {
		dao = new productDAO();
	}
	
	//제품 등록
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String input(Product product) {
		
		try {
		dao.insert(product);
		}catch (Exception e) {
			e.printStackTrace();
			return "student API: 등록 안됨!!";
		}
		return "product API : 등록 됨";
	}
	
	//제품 전체 목록
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProductList(){
		List<Product> productList = null;
		
		try {
		productList = dao.getAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return productList;
	}
	
	//상세정보
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProduct(@PathParam("id")String id) {
		Product product = null;
		
		product = dao.find(id);
		
		return product;
	}
	
	//제품 삭제
	@DELETE
	@Path("{id}")
	public String deProduct(@PathParam("id") int id) {
		
		try {
			dao.delProduct(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "Product API: 제품 삭제 실패!!" + id;
		}
		return "Product API: 제품 삭제 됨!!" + id;
		
	}
}
