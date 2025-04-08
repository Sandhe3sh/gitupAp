 package com.infosys.educationConsultancyApplication.dao;

import java.util.List;
import com.infosys.educationConsultancyApplication.bean.CourseSubscription;

public interface CourseSubscriptionDao {
    void save(CourseSubscription courseSubscription);
    CourseSubscription getSubscriptionById(String id);
    List<CourseSubscription> getAllSubscriptions();
    String generateNewSubscriptionId();
    void deleteSubscriptionById(String id);
	List<CourseSubscription> getCurrentSubscriptions();
	List<CourseSubscription> getAllSubscriptionByStudent(String id);
	String generateSubscriptionId();
}