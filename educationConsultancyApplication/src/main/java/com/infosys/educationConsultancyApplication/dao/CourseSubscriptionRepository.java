package com.infosys.educationConsultancyApplication.dao;

import com.infosys.educationConsultancyApplication.bean.CourseSubscription;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseSubscriptionRepository extends JpaRepository<CourseSubscription, String> {

	 @Query("SELECT MAX(subscriptionId) from CourseSubscription")
	 public String getMaxId();
	
	 @Query("SELECT c FROM CourseSubscription c WHERE c.studentId = :studentId")
	 List<CourseSubscription>findByStudentId(String studentId);
	 
	 @Query("SELECT c FROM CourseSubscription c WHERE c.courseId = :courseId")
	 List<CourseSubscription>findByCourseId(Long courseId);

	 
	 @Query("SELECT c FROM CourseSubscription c WHERE c.status = :status")
	 List<CourseSubscription>findByStatus(String status);

	 
	 
	 
	 
}