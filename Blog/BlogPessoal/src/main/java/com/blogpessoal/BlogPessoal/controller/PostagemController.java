package com.blogpessoal.BlogPessoal.controller;

import java.util.List;

import javax.validation.Valid;

import com.blogpessoal.BlogPessoal.model.postagem;
import com.blogpessoal.BlogPessoal.repository.PostagemRepository;


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


@RestController
@RequestMapping("/postagem")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository repository;

	@GetMapping
	public ResponseEntity<List<postagem>>  GetAll(){
		return ResponseEntity.ok(repository.findAll());
		
		
}
@GetMapping("/{id}")
public ResponseEntity<postagem> GetbyId(@PathVariable Long id){
	return repository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
	
}
@GetMapping("/titulo/{titulo}")
public ResponseEntity<List<postagem>> GetByTitulo(@PathVariable String titulo){
	
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
@PostMapping
public ResponseEntity<postagem> postpostagem (@Valid@ RequestBody postagem postagem) {
	return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
}

@PutMapping
public ResponseEntity<postagem> putPostagem (@Valid @RequestBody postagem postagem) {
	if(repository.existsById(postagem.getId())) {
return ResponseEntity.status(HttpStatus.OK)
		.body(repository.save(postagem));
	}
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

}

@DeleteMapping("/{id}")
public ResponseEntity<?> deletePostagem(@PathVariable Long id) {
	
 return repository.findById(id).map(resposta ->
 {
	 repository.deleteById(id);
return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
 })
.orElse(ResponseEntity.notFound().build());
 }
}	




