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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.garagecontrol.entity.Produto;
import com.garagecontrol.service.ProdutoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;


	@PostMapping /* *****************************************************  Salvar Produto */
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation("Cria um novo produto")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Produto salvo com sucesso"),
		@ApiResponse(code = 400, message = "Erro de validação")
	})
	public Produto save( @RequestBody @Valid Produto produto) {
		return produtoService.save(produto);
	}

	@PutMapping("{id}") /* ************************************************ Atualizar um Produto */
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation("Altera os dados de um produto")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Produto alterado com sucesso"),
		@ApiResponse(code = 400, message = "Erro de validação")
	})
	public Produto update( @RequestBody @Valid Produto produto ) {
		return produtoService.save(produto);
	}
	
	@DeleteMapping("{id}")  /* ********************************************* Deletar um Produto */
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation("Deleta um produto")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Produto deletado com sucesso"),
		@ApiResponse(code = 400, message = "Erro de validação")
	})
	public ResponseEntity<Produto> delete(@PathVariable Long id) {
		return produtoService.deleteById(id);
	}
	
	@GetMapping("/{id}") /* ************************************************ Buscar produto por ID */
	@ApiOperation("Obter detalhes de um produto pelo ID")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Produto encontrado"),
		@ApiResponse(code = 404, message = "Produto não encontrado para o ID informado")
	})
	public Optional<Produto> getProdutoById(@PathVariable @ApiParam("id") Long id) {
		return produtoService.findById(id);
	}
	
	
	@GetMapping("") /* ************************************************ Busca todos os produtos */
	@ApiOperation("Busca todos os produtos")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Pessoas encontrados com sucesso"),
		@ApiResponse(code = 400, message = "Erro de validação")
	})
	    public List<Produto> findAll(){
			return produtoService.findAll();
		}
}
