package com.garagecontrol.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.garagecontrol.entity.Pessoa;
import com.garagecontrol.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}
	
	
	public Optional<Pessoa> findById(Long id) {
		return pessoaRepository.findById(id);
	}

	
	public Pessoa save(Pessoa pessoa) {
		return pessoaRepository.saveAndFlush(pessoa);
	}

	
	public ResponseEntity<Pessoa> update(Pessoa pessoa) {
		return ResponseEntity.ok(pessoaRepository.save(pessoa));	
	}

	
	public ResponseEntity<Pessoa> deleteById(Long id) {
		if(pessoaRepository.existsById(id)) {
			pessoaRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}


	public List<Pessoa> buscarPorNome(String nomePessoa) {
		List<Pessoa> pessoa = pessoaRepository.buscarPorNome(nomePessoa);
		return pessoa;
		}
	}


