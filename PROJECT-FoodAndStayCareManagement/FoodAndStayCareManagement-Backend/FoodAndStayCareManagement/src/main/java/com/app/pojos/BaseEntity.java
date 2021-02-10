package com.app.pojos;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false,updatable = false)
	private Integer Id;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}	

}
