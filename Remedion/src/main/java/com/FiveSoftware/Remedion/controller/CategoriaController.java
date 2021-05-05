package com.FiveSoftware.Remedion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FiveSoftware.Remedion.model.Categoria;
import com.FiveSoftware.Remedion.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class CategoriaController {
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAllCategoria(){
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findByIdCategoria(@PathVariable long id){
		return repository.findById(id).map(res-> ResponseEntity.ok(res)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Categoria> postCategoria(@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<Categoria> putCategoria(@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void deleteByIdCategoria(@PathVariable long id ) {
		repository.deleteById(id);
		
	}
	
	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<Categoria>>findByTipoCategoria(@PathVariable String tipo){
		return ResponseEntity.ok(repository.findAllByTipoContainingIgnoreCase(tipo));
	}
}
