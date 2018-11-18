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
public class IngredientResource {
		
	@Autowired
	private IngredientRepository ingredientRepository;
	
	@GetMapping("/ingredient/{id}")
	public Ingredient retrieveIngredientId(@PathVariable long id) {
		Optional<Ingredient> ingredient = ingredientRepository.findById(id);
				
				if(!ingredient.isPresent())
					throw new IngredientNotFoundException("id-" + id);
		
		return ingredient.get();
	}
	
	@GetMapping("/ingredient")
	public List<Ingredient> retrieveAllIngredient() {
		return ingredientRepository.findAll();
	}	
	
	@DeleteMapping("/ingredient/{id}")
	public void deleteIngredient(@PathVariable long id) {
		ingredientRepository.deleteById(id);
	}

	@PostMapping("/ingredient")
	public ResponseEntity<Object> createIngredient(@RequestBody Ingredient ingredient) {
		Ingredient savedIngredient = ingredientRepository.save(ingredient);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedIngredient.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/ingredient/{id}")
	public ResponseEntity<Object> updateIngredient(@RequestBody Ingredient ingredient, @PathVariable long id) {

		Optional<Ingredient> ingredientOptional = ingredientRepository.findById(id);

		if (!ingredientOptional.isPresent())
			return ResponseEntity.notFound().build();

		ingredient.setId(id);
		
		ingredientRepository.save(ingredient);

		return ResponseEntity.noContent().build();
	}
	
}
