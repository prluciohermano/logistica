package com.garagecontrol.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.garagecontrol.entity.Pessoa;
import com.garagecontrol.service.PessoaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;

	
	@GetMapping /* ************************************************ Busca todos as Pessoas */
	@ApiOperation("Busca todos as pessoas")
	@ApiResponses({
		@ApiResponse(code = 200, message = "pessoas encontradas com sucesso"),
		@ApiResponse(code = 400, message = "Erro de validação")
	})
	public List<Pessoa> listar() {
		return pessoaService.findAll();
		
	}
	
	@GetMapping("/{id}")  /* ***************************************** Buscar pessoa por ID */
	@ApiOperation("Obter detalhes de um pessoa puxando pelo ID")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Pessoa encontrada"),
		@ApiResponse(code = 404, message = "Pessoa não encontrado para o ID informado")
	})
	public Optional<Pessoa> findById(@PathVariable Long id) {
		return pessoaService.findById(id);
	}
	
	@GetMapping(value = "buscarPorNome") /* *************************** Buscar pessoa por nome */
	@ApiOperation("Busca uma pessoa por nome")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Pessoa encontrado com sucesso"),
		@ApiResponse(code = 400, message = "Erro de validação")
	})
	
	public ResponseEntity<List<Pessoa>> buscarPorNome(@RequestParam(name = "nome") String nome) { /* Recebe os dados para consultar */

		List<Pessoa> pessoa = pessoaService.buscarPorNome(nome.trim().toUpperCase());

		return new ResponseEntity<List<Pessoa>>(pessoa, HttpStatus.OK);

	}
	
	@PostMapping  /* *****************************************************  Salvar pessoa */
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation("Cria um novo cliente")
	@ApiResponses({
		@ApiResponse(code = 201, message = "pessoa salva com sucesso"),
		@ApiResponse(code = 400, message = "Erro de validação")
	})
	public Pessoa save(@RequestBody @Valid Pessoa pessoa) {
		return pessoaService.save(pessoa);
	}
	
	@PutMapping("")  /* ********************** Atualizar uma pessoa */
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation("Altera os dados de um cliente")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Cliente alterado com sucesso"),
		@ApiResponse(code = 400, message = "Erro de validação")
	})
	public ResponseEntity<Pessoa> update( @RequestBody @Valid Pessoa pessoa){
			return pessoaService.update(pessoa);
	}
	
	@DeleteMapping("{id}")  /* ********************************************* Deletar uma pessoa */
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation("Deleta uma pessoa")
	@ApiResponses({
		@ApiResponse(code = 204, message = "pessoa deletada com sucesso"),
		@ApiResponse(code = 400, message = "Erro de validação")
	})
	public ResponseEntity<Pessoa> deleteById( @PathVariable Long id) {
		return pessoaService.deleteById(id);
	}
}
