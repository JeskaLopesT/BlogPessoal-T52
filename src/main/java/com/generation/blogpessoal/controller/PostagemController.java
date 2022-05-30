package com.generation.blogpessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;

// indica que a classe é uma classe controladora da api (onde ficam os endpoints)
@RestController

// permite que requisições de outras portas sejam aceitas na minha aplicação
@CrossOrigin("*")

// cria um endpoint 
@RequestMapping("/postagens")
public class PostagemController {

	// autowired funciona como injeção de dependencia, transferindo a responsabilidade de manipular o banco de dados para o PostagemRepository
	@Autowired
	private PostagemRepository repository;
	
	
	// indica o verbo que pode ser utilizado no endpoint
	@GetMapping
	public ResponseEntity<List<Postagem>> buscaPostagem(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> buscaPostagemPorId(@PathVariable Long id){
		return repository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Postagem> adicionaPostagem(@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	

}
