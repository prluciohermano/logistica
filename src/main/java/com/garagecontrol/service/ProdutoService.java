package com.garagecontrol.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.garagecontrol.entity.Produto;
import com.garagecontrol.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}
	
	
	public Optional<Produto> findById(Long id) {
		return produtoRepository.findById(id);
	}

	
	public Produto save(Produto produto) {
		return produtoRepository.saveAndFlush(produto);
	}

	
	public ResponseEntity<Produto> update(Produto produto) {
		return ResponseEntity.ok(produtoRepository.saveAndFlush(produto));	
	}

	
	public ResponseEntity<Produto> deleteById(Long id) {
		if(produtoRepository.existsById(id)) {
			produtoRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}


	public List<Produto> buscarPorNome(String nomeProduto) {
		List<Produto> produto = produtoRepository.buscarPorNome(nomeProduto);
		return produto;
		}

}
