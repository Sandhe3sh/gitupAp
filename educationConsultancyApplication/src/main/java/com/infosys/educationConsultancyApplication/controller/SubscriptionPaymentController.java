 package com.infosys.educationConsultancyApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.educationConsultancyApplication.bean.CourseSubscription;
import com.infosys.educationConsultancyApplication.bean.Student;
import com.infosys.educationConsultancyApplication.dao.CourseSubscriptionDao;
import com.infosys.educationConsultancyApplication.dao.StudentDao;
import com.infosys.educationConsultancyApplication.service.EduconUserService;
import com.infosys.educationConsultancyApplication.service.SubscriptionService;

@RestController
@RequestMapping("/edu-con")
@CrossOrigin(origins = "http://localhost:3636")
public class SubscriptionPaymentController {

    @Autowired
    private CourseSubscriptionDao courseSubscriptionDao;
    
    @Autowired
    private StudentDao studentDao;
    
    @Autowired
    private EduconUserService service;
    
    @Autowired
    private SubscriptionService subService;

    @PostMapping("/subscription")
    public void save(@RequestBody CourseSubscription subscription) {
    	String userId=service.getUserId();
    	Student student=studentDao.getStudentByUsername(userId);
    	subscription.setStudentId(student.getRegistrationNumber());
    	String endDate=subService.generateEndDate(subscription.getSubscriptionDate());
    	subscription.setEndDate(endDate);
    	subscription.setStatus("active");
    	courseSubscriptionDao.save(subscription);
    }
    
    @PutMapping("/subscription")
    public void update(@RequestBody CourseSubscription subscription) {
    	String userId=service.getUserId();
    	Student student=studentDao.getStudentByUsername(userId);
    	subscription.setStudentId(student.getRegistrationNumber());
    	String endDate=subService.generateEndDate(subscription.getSubscriptionDate());
    	subscription.setEndDate(endDate);
    	subscription.setStatus("active");
    	courseSubscriptionDao.save(subscription);
    }
//    @PostMapping("/subscriptions")
//    public CourseSubscription createSubscription(@RequestBody CourseSubscription courseSubscription) {
//        // Generate and assign the subscription ID
//        courseSubscription.setSubscriptionId(courseSubscriptionDao.generateNewSubscriptionId());
//        
//        // Set subscription date to current system date
//        String currentDate = LocalDate.now().toString();
//        courseSubscription.setSubscriptionDate(currentDate);
//        
//        // Calculate end date as 90 days from subscription date
//        String calculatedEndDate = LocalDate.now().plusDays(90).toString();
//        courseSubscription.setEndDate(calculatedEndDate);
//        
//        // Save the subscription
//        courseSubscriptionDao.save(courseSubscription);
//        return courseSubscription;
//    }
    
    @GetMapping("/subscriptions")
    public List<CourseSubscription> getAllSubscriptions() {
        return courseSubscriptionDao.getAllSubscriptions();
    }
    
    // This endpoint simply shows how the ID is generated
    @GetMapping("/generate")
    public String generateSubscriptionId() {
        return courseSubscriptionDao.generateNewSubscriptionId();
    }
    
    @GetMapping("/subscription/{id}")
    public CourseSubscription getSubscriptionById(@PathVariable String id) {
        return courseSubscriptionDao.getSubscriptionById(id);
    }
    
    
    @GetMapping("/subscription-current")
    public List<CourseSubscription>getCurrentSubscriptions(){
    	return courseSubscriptionDao.getCurrentSubscriptions();
    }
    
    
    @GetMapping("/subscription-stud/{id}")
    public List<CourseSubscription>getAllSubscriptionsByStudent(String id){
    	return courseSubscriptionDao.getAllSubscriptionByStudent(id);
    }
    
    @GetMapping("/subscription-id")
    public String generateSubscriptionId1(){
    	return courseSubscriptionDao.generateSubscriptionId();
    }
}