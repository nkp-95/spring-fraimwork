package ch11;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ListenerTestServlet
 */
public class ListenerTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ServletContext sc;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListenerTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		sc = getServletContext(); //인스턴스 사용(싱글톤)
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sc.setAttribute("scName", "홍길동");
		//중요 - 프로젝트 할때 사용자 정보 저장해놓을수 있음
		HttpSession s = request.getSession();
		s.setAttribute("ssName", s.getId() + " : 세션 속성 저장");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
