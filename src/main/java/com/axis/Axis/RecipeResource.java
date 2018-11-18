package com.axis.Axis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
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
	
	
	@DeleteMapping("/recipe/{id}")
	public void deleteRecipe(@PathVariable long id) {
		recipeRepository.deleteById(id);
	}

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
