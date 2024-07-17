package ch09;

import java.util.List;

public class StudentService {
	StudentDAO dao = new StudentDAO();
	
	public void insert(Student s) {
		dao.insert(s);
	}
	
	public List<Student> getAll() {
		return dao.getAll();
	}
}
