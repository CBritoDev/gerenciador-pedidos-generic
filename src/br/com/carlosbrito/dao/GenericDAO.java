package br.com.carlosbrito.dao;

import br.com.carlosbrito.interfaces.IGenericDAO;
import br.com.carlosbrito.interfaces.IPersistente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author carlos.brito
 * Criado em: 28/07/2025
 */
public  abstract class GenericDAO<T extends IPersistente> implements IGenericDAO<T> {
    protected Map<Class,Map<Long,T>> map;
    protected Map<Long,T> innerMapCache;

    public abstract Class<T> getClassType();

    //Inicializa o map e o mapa interno, caso esteja vazio ou não instanciado
    public GenericDAO(){
        this.map = new HashMap<>();
        this.innerMapCache = this.map.get(getClassType());
        if(innerMapCache == null){
            innerMapCache = new HashMap<>();
        }
        this.map.put(getClassType(), innerMapCache);
    }

    //cadastra a entity usando seu codigo como referência no mapa
    @Override
    public boolean cadastrar(T entity) {
        if(innerMapCache.containsKey(entity.getCodigo())){
            return false;
        }
        innerMapCache.put(entity.getCodigo(), entity);
        return true;
    }

    //exclui a entity usando o codigo como referência. Caso vazio, retorna excessão
    @Override
    public void excluir(Long codigo) {
        if(codigo == null){
            throw new IllegalArgumentException("O campo código é obrigatório");
        }
        innerMapCache.remove(codigo);
    }

    //altera a entity usando o codigo como refência, retornando feedbacks do processo
    @Override
    public void alterar(T entity) {
        T copiaSeguranca = consultar(entity.getCodigo());
        if(copiaSeguranca == null){
            System.out.println("Alteração não realizada por falta de informações");
            return;
        }
        innerMapCache.put(entity.getCodigo(), copiaSeguranca);
        System.out.println("Alteração realizada com sucesso!");
    }

    @Override
    public T consultar(Long codigo) {
        return innerMapCache.get(codigo);
    }

    //retorna uma coleção de T, mostrando os valores dentro do map
    @Override
    public Collection<T> buscarTodos() {
        return innerMapCache.values();
    }
}
