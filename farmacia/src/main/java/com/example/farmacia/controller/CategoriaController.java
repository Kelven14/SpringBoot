package com.example.farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.farmacia.model.Categoria;
import com.example.farmacia.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;

	//Listar todos as Categorias
		@GetMapping
		public ResponseEntity<List<Categoria>> GetAll() {
			return ResponseEntity.ok(repository.findAll());
		}

		//Listar uma Categoria usando o Id
		@GetMapping("/{id}")
		public ResponseEntity<Categoria> GetById(@PathVariable long id) {
			return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		}
		
		
		//cadastrar uma Categoria
		@PostMapping
		public ResponseEntity<Categoria> post(@RequestBody Categoria categoria) {
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
		}
		
		
		//atualizar um dado de uma Categoria
		@PutMapping
		public ResponseEntity<Categoria> put(@RequestBody Categoria categoria) {
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
		}
		
		//Deletar uma Categoria usando o Id
		@DeleteMapping("/{id}")
		public void delete(@PathVariable long id) {
			repository.deleteById(id);
		}
	
	
}