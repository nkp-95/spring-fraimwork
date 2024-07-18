package ch09;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

@WebServlet("/prodControl")
public class ProdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    productDAO dao;
	
    public ProdController() {
        super();
    }
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new productDAO();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		String view = "";
		
		if(action == null) {
			getServletContext().getRequestDispatcher("/prodControl?action=list")
				.forward(request, response);
		}else{
			switch(action) {
				case "list": view = list(request, response); break;	//제품 목록
				case "insert": view = insert(request, response); break; //제품 등록
				case "info": view = info(request, response); break;  //제품 상세정보
				case "update": view = update(request, response); break;	//수정
			}
			getServletContext().getRequestDispatcher("/ch09/" + view)
				.forward(request, response);
		}
		
	}
	private String update(HttpServletRequest request, HttpServletResponse response) {
		Product p = new Product();
		
		try {
			BeanUtils.populate(p, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		dao.update(p);
		
		return "productInfo.jsp";
	}

	//제품 리스트
	private String list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("products", dao.getAll());
		return "productInfo.jsp";
	}
	
	//제품 등록
	private String insert(HttpServletRequest request, HttpServletResponse response) {
		Product p = new Product();
		
		try {
			BeanUtils.populate(p, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		dao.insert(p);
		
		return list(request, response);
	}
	
	//상세정보 조회
	private String info(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("p", dao.find(request.getParameter("id")));
		return "prodInfo.jsp";
	}

}
