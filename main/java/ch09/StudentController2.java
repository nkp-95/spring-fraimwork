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

@WebServlet("/studentControl2")
public class StudentController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    StudentService service;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		service = new StudentService();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");		//컨트롤러로 시작
		String view = "";
		
		if(action == null) {
			getServletContext().getRequestDispatcher("/studentControl2?action=list")
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
		request.setAttribute("students", service.getAll());  // 리스트에 입력 추가
		return "studentInfo2.jsp";
	}

	public String insert(HttpServletRequest request, HttpServletResponse response) {
		Student s = new Student();
		
		try {
			BeanUtils.populate(s, request.getParameterMap());		//리스트 정보를 읽어옴
		} catch (Exception e) {
			e.printStackTrace();
		}
		service.insert(s);//읽어온 정보 insert에 보내줌
		
		return list(request, response);
	}
}
