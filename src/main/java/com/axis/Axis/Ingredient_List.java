package com.axis.Axis;

import javax.persistence.*;
/**
 * 
 * @author Joaki
 * Entity class for the ingredient list table. GenerationType.IDENTITY to avoid non-unique primary keys. (default is .AUTO which caused duplicated PKs)
 */
@Entity
public class Ingredient_List {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Long recipe_id;
	Long ingredient_id;
	Long amount;
}