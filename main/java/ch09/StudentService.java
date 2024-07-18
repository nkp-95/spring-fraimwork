package ch09;

import java.util.List;

public class StudentService {
	StudentDAO dao = new StudentDAO();
	
	public void insert(Student s) {
		//안에 비즈니스 처리로직 가능
		dao.insert(s);
	}
	
	public List<Student> getAll() {
		//안에 비즈니스 처리로직 가능
		return dao.getAll();
	}
}
