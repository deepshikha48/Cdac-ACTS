package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity{

	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(unique = false)
	private User student;
	
	@Column(name = "total_amount")
	private double totalBillingAmount;
	
	public Order() {
		System.out.println("In Constructor of: "+getClass().getName());
	}

	public Order(User studentId, double totalBillingAmount) {
		super();
		this.student = studentId;
		this.totalBillingAmount = totalBillingAmount;
	}
	

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public double getTotalBillingAmount() {
		return totalBillingAmount;
	}

	public void setTotalBillingAmount(double totalBillingAmount) {
		this.totalBillingAmount = totalBillingAmount;
	}

	@Override
	public String toString() {
		return "Order [Id=" + getId() + "studentId=" + student + ", totalBillingAmount=" + totalBillingAmount + "]";
	}
	
	
}
