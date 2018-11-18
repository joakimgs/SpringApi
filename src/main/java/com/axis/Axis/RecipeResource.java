package com.axis.Axis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
/**
 * 
 * @author Joaki
 * Resource class for Recipe entity to hold CRUD-methods (get, post, put, delete)
 * @RestController = @Controller + @ResponseBody beans returned are converted to/from JSON/XML.
 * @Autowired wiring the RecipeRepository to retrieve and save data to database.
 * @GetMapping = GET-method, get data from database and return it
 * @PostMapping = POST-method, add Id + value to database 
 * @PutMapping = PUT-method, get database value and save a new value in that ID-index
 */
@RestController
public class RecipeResource {
		
	@Autowired
	private RecipeRepository recipeRepository;

	@GetMapping("/recipe/{id}")
	public Recipe retrieveRecipeId(@PathVariable long id) {
		Optional<Recipe> recipe = recipeRepository.findById(id);
				if(!recipe.isPresent())
					throw new RecipeNotFoundException("id-" + id);
		return recipe.get();
	}
	
//	@GetMapping("/recipe=q{search_string}")
//	public String retreieveRecipeList(@PathVariable String name) {
//		List<Recipe> recipe = recipeRepository.findAll();
//		
//				if(!recipe.isEmpty())
//					throw new RecipeNotFoundException("name-" + name);
//				
//				return recipe.toString();
//	}
	

	@PostMapping("/recipe")
	public ResponseEntity<Object> createRecipe(@RequestBody Recipe recipe) {
		Recipe savedRecipe = recipeRepository.save(recipe);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedRecipe.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/recipe/{id}")
	public ResponseEntity<Object> updateRecipe(@RequestBody Recipe recipe, @PathVariable long id) {

		Optional<Recipe> recipeOptional = recipeRepository.findById(id);

		if (!recipeOptional.isPresent())
			return ResponseEntity.notFound().build();

		recipe.setId(id);
		
		recipeRepository.save(recipe);

		return ResponseEntity.noContent().build();
	}
	
}
