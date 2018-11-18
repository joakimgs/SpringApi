package com.axis.Axis;

import javax.persistence.*;

@Entity
public class Ingredient_List {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Long recipe_id;
	Long ingredient_id;
	Long amount;
}