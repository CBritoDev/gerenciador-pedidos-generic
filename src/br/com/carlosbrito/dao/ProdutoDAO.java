package br.com.carlosbrito.dao;

import br.com.carlosbrito.interfaces.IProdutoDAO;
import br.com.carlosbrito.model.Produto;

import java.util.Map;

/**
 * @author carlos.brito
 * Criado em: 28/07/2025
 */
public class ProdutoDAO extends GenericDAO<Produto> implements IProdutoDAO {

    public ProdutoDAO() {
        super();
    }

    @Override
    public Class<Produto> getClassType() {
        return Produto.class;
    }
}
