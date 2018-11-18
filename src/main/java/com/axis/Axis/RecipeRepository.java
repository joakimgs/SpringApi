package com.axis.Axis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * 
 * @author Joaki
 * JPA repository to read Recipe from database @Recipe = Entity, @Long = primary key of Recipe entity
 */
@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
		
}
