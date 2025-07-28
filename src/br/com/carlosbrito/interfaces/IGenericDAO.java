package br.com.carlosbrito.interfaces;

import java.util.Collection;

/**
 * Contrato para implementação CRUD
 * @author carlos.brito
 * Criado em: 28/07/2025
 */
public interface IGenericDAO<T extends IPersistente> {
    public boolean cadastrar(T entity);
    public void excluir(Long codigo);
    public void alterar(T entity);
    public T consultar(Long codigo);
    public Collection<T> buscarTodos();

}
