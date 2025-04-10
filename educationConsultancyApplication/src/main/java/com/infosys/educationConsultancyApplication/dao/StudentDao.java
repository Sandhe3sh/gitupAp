////package com.infosys.educationConsultancyApplication.dao;
////
////import java.util.List;
////
////import org.springframework.data.jpa.repository.Query;
////
////import com.infosys.educationConsultancyApplication.bean.Student;
////
////public interface StudentDao {
//
//
////
////    public void save(Student student);
////    public Student getStudentById(String registrationNumber);
////    public List<Student> getAllStudents();
////    public void deleteStudentById(String registrationNumber);
////    //public List<Student> getStudentsByLevel(String studentLevel);
////    public String generateRegistration ();
////    @Query("select a from Student a where a.status='true'")
////
////	public List<Student> getCurrentStudents();
//// 
////}
//
//package com.infosys.educationConsultancyApplication.dao;
//
//import java.util.List;
//
//import com.infosys.educationConsultancyApplication.bean.Student;
//
//public interface StudentDao {
//
//    public void save(Student student);
//    public Student getStudentById(String registrationNumber);
//    public List<Student> getAllStudents();
//    //public void deleteStudentById(String registrationNumber);
//    //public List<Student> getStudentsByLevel(String studentLevel);
//    public String generateRegistration ();
//    public List<Student> getCurrentStudents();
//    public String getStudentStatusByUsername(String username);
//    public Student getStudentByUsername(String username);
//
//}

package com.infosys.educationConsultancyApplication.dao;

import java.util.List;

import com.infosys.educationConsultancyApplication.bean.Student;

public interface StudentDao {
	public void save(Student student);
	public Student getStudentById(String id);
	public List<Student> getAllStudents();
	public String generateRegistration();
	public List<Student> getCurrentStudents();
	public String getStudentStatusByUsername(String username);
	public Student getStudentByUsername(String username);
}
