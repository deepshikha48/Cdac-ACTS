package com.app.pojos;

import javax.persistence.*;

@MappedSuperclass
//no table will be associated with this class. 
//Usage is collecting common fields n annotations (extended by actual entities)
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

}
