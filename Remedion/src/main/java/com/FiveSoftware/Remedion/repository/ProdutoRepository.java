package com.FiveSoftware.Remedion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FiveSoftware.Remedion.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);
	
	public List<Produto> findAllByNomeContainingIgnoreCaseAndMunicipioCidadeContainingIgnoreCaseAndZonaContainingIgnoreCase(String nome, String municipioCidade, String zona);
	
	public List<Produto> findAllByPostoContainingIgnoreCase(String posto);
	
	public List<Produto> findAllByNomeContainingIgnoreCaseAndPostoContainingIgnoreCase(String nome, String posto);
}
