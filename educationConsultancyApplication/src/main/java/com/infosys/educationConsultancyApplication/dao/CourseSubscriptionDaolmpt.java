 package com.infosys.educationConsultancyApplication.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.infosys.educationConsultancyApplication.bean.CourseSubscription;

@Service
@Repository
public class CourseSubscriptionDaolmpt implements CourseSubscriptionDao {
    @Autowired
    private CourseSubscriptionRepository courseSubscriptionRepository;

    @Override
    public void save(CourseSubscription courseSubscription) {
        courseSubscriptionRepository.save(courseSubscription);
    }

    @Override
    public CourseSubscription getSubscriptionById(String id) {
        return courseSubscriptionRepository.findById(id).orElse(null);
    }

    @Override
    public List<CourseSubscription> getAllSubscriptions() {
        return courseSubscriptionRepository.findAll();
    }

    @Override
    public String generateNewSubscriptionId() {
        String id = courseSubscriptionRepository.getMaxId();
        if (id == null)
            return "SC1001";
        else {
            int numericPart = Integer.parseInt(id.substring(2));
            numericPart++;
            return "SC" + numericPart;
        }
    }

    @Override
    public void deleteSubscriptionById(String id) {
        courseSubscriptionRepository.deleteById(id);
    }

	@Override
	public List<CourseSubscription> getCurrentSubscriptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseSubscription> getAllSubscriptionByStudent(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateSubscriptionId() {
		// TODO Auto-generated method stub
		return null;
	}
}