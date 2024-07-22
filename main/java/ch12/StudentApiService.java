package ch12;

import java.sql.SQLException;
import java.util.List;
import ch09.Student;
import ch09.StudentDAO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/Student")
public class StudentApiService {
	
	StudentDAO  dao;
	
	public StudentApiService() {
		dao = new StudentDAO();
	}
	
	//학생 등록
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String input(Student student) {
		
		try {
		dao.insert(student);
		}catch (Exception e) {
			e.printStackTrace();
			return "student API: 등록 안됨!!";
		}
		return "student API: 등록됨";
	}
	
	//학생 목록(목록 전체만 가져옴)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudentList(){
		List<Student> studentsList = null;
		
		studentsList = dao.getAll();
		
		return studentsList;
	}
	
	//상세정보 가져오기
	@GET
	@Path("{id}")//가져올 아이디
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudent (@PathParam("id")int id) {//StudentDAO 상세페이지 메서드가 있어야 가져올수 있음
		Student student = null;
		
		try {
			student = dao.getStudent(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return student;
	}
	
	//학생 삭제
	@DELETE
	@Path("{id}")//위에 학생 상세정보와 같이 StudentDAO 상세페이지 메서드가 있어야 지울수 있음
	public String deStudent(@PathParam("id") int id) {
		
		try {
			dao.delStudent(id);
		}catch (Exception e){
			return "student API: 학생 삭제 실패!! - " + id;
		}
		
		return "student API: 학생 삭제됨!!" + id;
	}
	
}
