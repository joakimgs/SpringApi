package com.axis.Axis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * 
 * @author Joaki
 * JPA repository to read Ingredient from database @Ingredient = Entity, @Long = primary key of Ingredient entity
 */
@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
		
}
