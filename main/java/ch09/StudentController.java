package ch09;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;  //없으면 populate 함수 오류남

@WebServlet("/studentControl")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    StudentDAO dao;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new StudentDAO();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");		//컨트롤러로 시작
		String view = "";
		
		if(action == null) {
			getServletContext().getRequestDispatcher("/studentControl?action=list")
			.forward(request, response);
		}else {
			switch(action) {
				case "list": view = list(request, response); break;
				case"insert": view = insert(request, response); break;
			}
			getServletContext().getRequestDispatcher("/ch09/" + view)
			.forward(request, response);
			
		}
	}
	
	public String list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("students", dao.getAll());  // 리스트 정보를 읽어옴
		return "studentInfo.jsp";
	}

	public String insert(HttpServletRequest request, HttpServletResponse response) {
		Student s = new Student();
		
		try {
			BeanUtils.populate(s, request.getParameterMap());		//리스트에 입력 추가
		} catch (Exception e) {
			e.printStackTrace();
		}
		dao.insert(s);
		
		return list(request, response);
	}
}
