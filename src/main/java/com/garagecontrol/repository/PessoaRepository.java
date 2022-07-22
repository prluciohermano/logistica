package com.garagecontrol.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.garagecontrol.entity.Pessoa;

@Repository
@Transactional
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	@Query(value = "select p from Pessoa p where upper(trim(p.nome)) like %?1%")
	List<Pessoa> buscarPorNome(String nome);
}
