package com.axis.Axis;

import javax.persistence.*;
/**
 * 
 * @author Joaki
 * JPA Entity class for the Ingredient table. 
 * 
 */
@Entity
public class Ingredient {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	public Ingredient() {
		super();
	}
	
	public Ingredient(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}


