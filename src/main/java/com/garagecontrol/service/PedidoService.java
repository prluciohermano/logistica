package com.garagecontrol.service;

import java.util.Optional;

import com.garagecontrol.dto.PedidoDTO;
import com.garagecontrol.entity.Pedido;
import com.garagecontrol.enums.StatusPedido;

public interface PedidoService {
	Pedido salvar( PedidoDTO dto );
	
	Optional<Pedido> obterPedidoCompleto(Long id);
	
	void atualizarStatus(Long id, StatusPedido statusPedido);
}
