package br.com.carlosbrito.main;

import br.com.carlosbrito.dao.PedidoDAO;
import br.com.carlosbrito.dao.ProdutoDAO;
import br.com.carlosbrito.facade.ProcessadorPedidosFacade;
import br.com.carlosbrito.interfaces.IPersistente;
import br.com.carlosbrito.model.ItemPedido;
import br.com.carlosbrito.model.Pedido;
import br.com.carlosbrito.model.Produto;
import br.com.carlosbrito.util.StatusPedido;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author carlos.brito
 * Criado em: 28/07/2025
 */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();

        ProcessadorPedidosFacade novoPedido = new ProcessadorPedidosFacade(produtoDAO, pedidoDAO);

        Produto toddynho = new Produto.ProdutoBuilder("Toddynho", 9000123l)
                .comValor(new BigDecimal(6.79))
                .build();
        Produto leite =  new Produto.ProdutoBuilder("Leite I", 9000124l)
                .comValor(new BigDecimal(4.70))
                .build();
        Produto chantilly =  new Produto.ProdutoBuilder("Chantilly", 9000142l)
                .comValor(new BigDecimal(12.90))
                .build();

        novoPedido.adicionarProdutoAoCatalogo(toddynho);
        novoPedido.adicionarProdutoAoCatalogo(leite);
        novoPedido.adicionarProdutoAoCatalogo(chantilly);


        ItemPedido itemPedido = new ItemPedido(toddynho,10);
        ItemPedido itemPedido2 = new ItemPedido(leite,12);
        ItemPedido itemPedido3 = new ItemPedido(chantilly,6);
        List<ItemPedido> itensPedidos = new ArrayList<>();
        itensPedidos.add(itemPedido);
        itensPedidos.add(itemPedido3);
        itensPedidos.add(itemPedido2);

        Pedido pedido = new Pedido.PedidoBuilder(1l)
                .comDataCriacao(LocalDate.now())
                .build();

        novoPedido.realizarNovoPedido(1l, itensPedidos);

        novoPedido.atualizarStatusPedido(1l, StatusPedido.FINALIZADO);

        System.out.println(produtoDAO.buscarTodos());
        System.out.println(pedidoDAO.buscarTodos());
    }
}