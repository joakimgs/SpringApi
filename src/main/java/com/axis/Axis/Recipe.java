package com.axis.Axis;

import javax.persistence.*;
/**
 * 
 * @author Joaki
 * JPA Entity class for the Recipe table. 
 * 
 */
@Entity
public class Recipe {
	@Id
	Long id;
	String name;
	Long people;
	
	public Recipe() {
		super();
	}
	
	public Recipe(Long id, String name, Long people) {
		super();
		this.id = id;
		this.name = name;
		this.people = people;
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
	
	public Long people() {
		return people;
	}
	
	public void setPeople() {
		this.people = people;
	}

	

}
