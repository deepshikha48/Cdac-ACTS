package com.app.pojos;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "feedback")
public class Feedback extends BaseEntity{
	
	//@Size(min = 1, max = 5) 
	@Column(nullable = false)
	private int rating;
	
	@Column(length=100)
	private String description;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(nullable = false,name="user_id")
	private User userId;
	
	@Column(name="date_time")
	private LocalDateTime  dateTime;
	
	public Feedback() {
		System.out.println("in constructor of "+getClass().getName());
	}

	public Feedback( int rating, String description, User userId, LocalDateTime dateTime) {
		super();
		this.rating = rating;
		this.description = description;
		this.userId = userId;
		this.dateTime = dateTime;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Feedback [rating=" + rating + ", description=" + description + ", dateTime=" + dateTime + ", Id="
				+ getId() + "]";
	}

	
	
	

}
