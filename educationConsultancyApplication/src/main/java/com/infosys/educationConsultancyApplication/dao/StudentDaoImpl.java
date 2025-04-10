//package com.infosys.educationConsultancyApplication.dao;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//
//import com.infosys.educationConsultancyApplication.bean.Student;
//
//@Repository
//@Service
//public class  StudentDaolmpt implements StudentDao {
//    @Autowired
//    private StudentRepository repository;
//
//    @Override
//    public void save(Student student) {
//        repository.save(student);
//    }
//
//    @Override
//    public Student getStudentById(String id) {
//        return repository.findById(id).orElse(null); // Safely handling Optional
//    }
//
//    @Override
//    public List<Student> getAllStudents() {
//        return repository.findAll();
//    }
//
//    @Override
//    public void deleteStudentById(String id) {
//        repository.deleteById(id);
//    }
//
//
//    @Override
//	public String generateRegistration() {
//		return null;
//	}
//}
//
//package com.infosys.educationConsultancyApplication.dao;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//
//import com.infosys.educationConsultancyApplication.bean.Student;
//
//@Repository
//@Service
//public class StudentDaoImpl implements StudentDao {
//    @Autowired
//    private StudentRepository repository;
//
//    @Override
//    public void save(Student student) {
//        repository.save(student);
//    }
//
//    @Override
//    public Student getStudentById(String id) {
//        return repository.findById(id).orElse(null); // Safely handling Optional
//    }
//
//    @Override
//    public List<Student> getAllStudents() {
//        return repository.findAll();
//    }
//
//    @Override
//	public String generateRegistration() {
//    	Long id=0L;
//		String val=repository.getMaxRegistrationNumber();
//		if(val==null)
//			id=100001L;
//		else {
//			id=Long.parseLong(val.substring(1));
//			id++;
//		}
//		String newId="S"+id;  	
//		return newId;
// 
//	}
//    @Override
//    public List<Student> getCurrentStudents(){
//    	return repository.getCurrentStudents();
//    }
//    
//    @Override
//    public String getStudentStatusByUsername(String username) {
//    	return repository.getStudentStatusByUsername(username);
//    }
//    @Override
//    public Student getStudentByUsername(String username) {
//    	return repository.getStudentByUsername(username);
//    }
//    
//    
////    
////    @Override
////    public String getStudentByUsername(String username) {
////    	return repository.getStudentByUsername(username);
////    }
//    
//}


package com.infosys.educationConsultancyApplication.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.infosys.educationConsultancyApplication.bean.Student;

@Service
@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private StudentRepository repository;
	
	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		repository.save(student);

	}

	@Override
	public Student getStudentById(String id) {
		// TODO Auto-generated method stub		
		return repository.findById(id).get();
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}


	@Override
	public String generateRegistration() {
		// TODO Auto-generated method stub
		Long id = 0L;
		String val = repository.getMaxRegistration();
		if(val == null)
			id=100001L;
		else { 
			id=Long.parseLong(val.substring(1));
			id++;
		}
		String newId = "S"+id;
		return newId;
	}

	@Override
	public List<Student> getCurrentStudents() {
		// TODO Auto-generated method stub
		return repository.getCurrentStudents();
	}
	
	@Override
	public String getStudentStatusByUsername(String username) {
		return repository.getStudentStatusByUsername(username);
	}

	@Override
	public Student getStudentByUsername(String username) {
		// TODO Auto-generated method stub
		return repository.getStudentByUsername(username);
	}
	
	

}