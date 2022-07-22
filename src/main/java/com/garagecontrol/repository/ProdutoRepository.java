package com.garagecontrol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.garagecontrol.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	@Query(value = "select p from Produto p where upper(trim(p.descricao)) like %?1%")
	List<Produto> buscarPorNome(String nome);

}
