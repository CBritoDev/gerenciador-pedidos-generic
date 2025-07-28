package br.com.carlosbrito.dao;

import br.com.carlosbrito.model.Pedido;

import java.util.Map;

/**
 * @author carlos.brito
 * Criado em: 28/07/2025
 */
public class PedidoDAO extends GenericDAO<Pedido>{

    public PedidoDAO() {
        super();
    }

    @Override
    public Class<Pedido> getClassType() {
        return Pedido.class;
    }
}
