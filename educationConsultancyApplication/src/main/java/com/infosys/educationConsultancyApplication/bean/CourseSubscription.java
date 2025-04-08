package com.infosys.educationConsultancyApplication.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CourseSubscription{
	public CourseSubscription() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CourseSubscription(String subscriptionId, String studentId, Long courseId, String subscriptionDate, String endDate,
			Integer installments, Double installmentAmount, String status) {
		super();
		this.subscriptionId = subscriptionId;
		this.studentId = studentId;
		this.courseId = courseId;
		this.subscriptionDate = subscriptionDate;
		this.endDate = endDate;
		this.installments = installments;
		this.installmentAmount = installmentAmount;
		this.status = status;
	}
	@Id
	private String subscriptionId;//auto generated
	private String studentId;// automatically assigned
	private Long courseId;  //auto assignment
	private String subscriptionDate; // auto assignment from system date
	private String endDate;  //calculated assignment 90 days from sub date
	private Integer installments; //
	private Double installmentAmount;
	private String status;// active(true) //expired(false)
	public String getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getSubscriptionDate() {
		return subscriptionDate;
	}
	public void setSubscriptionDate(String subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Integer getInstallments() {
		return installments;
	}
	public void setInstallments(Integer installments) {
		this.installments = installments;
	}
	public Double getInstallmentAmount() {
		return installmentAmount;
	}
	public void setInstallmentAmount(Double installmentAmount) {
		this.installmentAmount = installmentAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Subscription [subscriptionId=" + subscriptionId + ", studentId=" + studentId + ", courseId=" + courseId
				+ ", subscriptionDate=" + subscriptionDate + ", endDate=" + endDate + ", installments=" + installments
				+ ", installmentAmount=" + installmentAmount + ", status=" + status + "]";
	}
	
	
	
	
}