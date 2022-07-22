package com.garagecontrol.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.garagecontrol.entity.Pedido;
import com.garagecontrol.entity.Pessoa;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByPessoa(Pessoa pessoa);
	
	@Query(" select p from Pedido p left join fetch p.itens where p.id = :id ")
	Optional<Pedido> findByIdFetchItens(@Param("id") Long id);
}
