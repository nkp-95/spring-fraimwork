package ch09;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/departmentControl")
public class DepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    DepartmentDAO dao;
	
    public DepartmentController() {
        super();
        
    }


	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new DepartmentDAO();
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		String view = "";
		if(action == null) {
			getServletContext().getRequestDispatcher("/departmentControl?action=list").forward(request, response);
		}else {
			switch(action) {
			case "list": view = list(request, response); break;
			case "insert": view = insert(request, response); break;
			}
			getServletContext().getRequestDispatcher("/ch09/" + view).forward(request, response);
		}
	}
	
	public String list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("departments", dao.getAll());
		return "departmentInfo.jsp";
	}

	public String insert(HttpServletRequest request, HttpServletResponse response) {
		Department d = new Department();
		
		try {
			BeanUtils.populate(d, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		dao.insert(d);
		
		return list(request, response);
	}


	

}
