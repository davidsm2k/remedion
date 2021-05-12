package com.FiveSoftware.Remedion.controller;

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

import com.FiveSoftware.Remedion.model.Produto;
import com.FiveSoftware.Remedion.repository.ProdutoRepository;

@RestController
@RequestMapping ("/produto")
@CrossOrigin(origins = "*" , allowedHeaders = "*")
public class ProdutoController {
	@Autowired
	private ProdutoRepository repository;

	@GetMapping
	public ResponseEntity <List<Produto>> findAllProduto() 
	{
		return ResponseEntity.ok(repository.findAll());
		}
	@GetMapping ("/{id}")
	public ResponseEntity <Produto> findByIdProduto(@PathVariable long id) 
	{
		return repository.findById(id).map(Resp -> ResponseEntity.ok(Resp)).orElse(ResponseEntity.notFound().build());
	}
	@PostMapping
	public ResponseEntity <Produto> postProduto (@RequestBody Produto produto) 
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	@PutMapping
	public ResponseEntity <Produto> putProduto (@RequestBody Produto produto) 
	{
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
		
	}
	@DeleteMapping ("/{id}")
	public void deleteByIdProduto (@PathVariable long id) 
	{
		repository.deleteById(id);
	}
	@GetMapping ("/nome/{nome}")
	public ResponseEntity<List <Produto>> findAllByNomeProduto(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@GetMapping ("/completa/{nome}/{cidade}/{zona}")
	public ResponseEntity<List <Produto>> findAllByNomeProdutoCidadeZona(@PathVariable String nome, @PathVariable String cidade, @PathVariable String zona) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCaseAndMunicipioCidadeContainingIgnoreCaseAndZonaContainingIgnoreCase(nome,cidade,zona));
	}
	
	@GetMapping ("/posto/{posto}")
	public ResponseEntity<List <Produto>> findAllByPosto(@PathVariable String posto) {
		return ResponseEntity.ok(repository.findAllByPostoContainingIgnoreCase(posto));
	}
	
	@GetMapping ("/nomePosto/{nome}/{posto}")
	public ResponseEntity<List <Produto>> findAllByNomePosto(@PathVariable String nome, @PathVariable String posto) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCaseAndPostoContainingIgnoreCase(nome, posto));
	}
		
	
}
