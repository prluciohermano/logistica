package com.garagecontrol.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.garagecontrol.entity.Usuario;
import com.garagecontrol.repository.UsuarioRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	private UsuarioRepository usuarioRepository;
	
	@GetMapping /******************************************** Listar usuários */
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario> listar(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/{id}") /*********************************** Buscar usuário por ID */
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Usuario> buscar(@PathVariable Long id){
		return usuarioRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping /******************************************** Adicionar usuário */
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario adicionar(@Valid @RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@PutMapping("/{id}") /************************************ Atualizar usuário */
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Usuario> atualizar(@PathVariable Long id,
			@Valid @RequestBody Usuario usuario){
		if(!usuarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		usuario = usuarioRepository.saveAndFlush(usuario);
		return ResponseEntity.ok(usuario);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> remover(@PathVariable Long id){
		if(!usuarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		usuarioRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
