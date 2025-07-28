package br.com.carlosbrito.model;

import br.com.carlosbrito.interfaces.IPersistente;
import br.com.carlosbrito.util.StatusPedido;

import java.time.LocalDate;
import java.util.List;

/**
 * @author carlos.brito
 * Criado em: 28/07/2025
 */
public class Pedido implements IPersistente {
    private final Long codigo;
    private final LocalDate dataCriacao;
    private StatusPedido status;
    private List<ItemPedido> itensPedido;

    private Pedido(PedidoBuilder builder){
        this.codigo = builder.getCodigo();
        this.dataCriacao = builder.getDataCriacao();
        this.status = builder.getStatus();
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }


    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status){
        this.status = status;
    }

    @Override
    public Long getCodigo() {
        return this.codigo;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "codigo=" + codigo +
                ", dataCriacao=" + dataCriacao +
                ", status=" + status +
                '}';
    }

    public static class PedidoBuilder{
        private Long codigo;
        private LocalDate dataCriacao = LocalDate.now();
        private StatusPedido status =  StatusPedido.PENDENTE;

        public PedidoBuilder(Long codigo){
            if(codigo == null){
                throw new IllegalArgumentException("O campo código é obrigatório");
            }
            this.codigo = codigo;
        }

        public PedidoBuilder comDataCriacao(LocalDate dataCriacao){
            this.dataCriacao = dataCriacao;
            return this;
        }

        public PedidoBuilder comStatus(StatusPedido status){
            this.status = status;
            return this;
        }

        public Pedido build(){
            return new Pedido(this);
        }

        public Long getCodigo() {
            return codigo;
        }

        public LocalDate getDataCriacao() {
            return dataCriacao;
        }

        public StatusPedido getStatus() {
            return status;
        }
    }


}
