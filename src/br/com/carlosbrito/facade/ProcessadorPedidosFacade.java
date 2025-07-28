package br.com.carlosbrito.facade;

import br.com.carlosbrito.dao.PedidoDAO;
import br.com.carlosbrito.dao.ProdutoDAO;
import br.com.carlosbrito.model.ItemPedido;
import br.com.carlosbrito.model.Pedido;
import br.com.carlosbrito.model.Produto;
import br.com.carlosbrito.util.StatusPedido;

import java.util.List;

/**
 * @author carlos.brito
 * Criado em: 28/07/2025
 */
public class ProcessadorPedidosFacade {
    private ProdutoDAO produtoDAO;
    private PedidoDAO pedidoDAO;

    public ProcessadorPedidosFacade(ProdutoDAO produtoDAO, PedidoDAO pedidoDAO){
        this.pedidoDAO = pedidoDAO;
        this.produtoDAO = produtoDAO;
    }

    public void adicionarProdutoAoCatalogo(Produto produto){
        if(produto == null){
            throw new IllegalArgumentException("O campo vazio é obrigatório.");
        }else{
            try {
                produtoDAO.cadastrar(produto);
            }catch (Exception e){
                System.out.println("ERRO:"+ e.getMessage());
            }
        }

    }
    public Pedido realizarNovoPedido(Long codigoPedido, List<ItemPedido> itens){
        try{
            Pedido pedido = new Pedido.PedidoBuilder(codigoPedido).build();
            pedido.setItensPedido(itens);

            if(pedido == null){
                System.out.println("O pedido está vazio");
            }else{
                pedidoDAO.cadastrar(pedido);
                return pedido;
            }
        }catch(IllegalArgumentException e){
            System.out.println("ERRO. CAMPOS OBRIGATÓRIOS VAZIOS: " + e.getMessage());
        }
        return null;
    }

    public void atualizarStatusPedido(Long codigoPedido, StatusPedido statusPedido){
        Pedido pedido = pedidoDAO.consultar(codigoPedido);
        if(pedido != null){
            pedido.setStatus(statusPedido);
            pedidoDAO.alterar(pedido);
            System.out.println("Status do pedido alterado com sucesso!");
        }else{
            System.out.println("Não foi possível atualizar o pedido. Informações necessárias encontram-se vazias.");
        }
    }
}
