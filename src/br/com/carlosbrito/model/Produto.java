package br.com.carlosbrito.model;

import br.com.carlosbrito.interfaces.IPersistente;

import java.math.BigDecimal;


/**
 * @author carlos.brito
 * Criado em: 28/07/2025
 */
public class Produto implements IPersistente {
    private String nome;
    private BigDecimal valor;
    private Long codigo;

    private Produto(ProdutoBuilder builder){
        this.nome = builder.getNome();
        this.valor = builder.getValor();
        this.codigo = builder.getCodigo();
    }


    @Override
    public Long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public String toString(){
        return String.format(
                "Produto: %s\nValor: R$%.2f\nCódigo: %d",
                nome, valor, codigo
        );
    }

    public static class ProdutoBuilder{
        private String nome;
        private BigDecimal valor;
        private Long codigo;


        /***
         * Construtor builder torna o campo codigo obrigatório
         *
         */
        public ProdutoBuilder(String nome,Long codigo){
            if(codigo == null || nome.equals("") ){
                throw new IllegalArgumentException("O campo código e nome são obrigatórios!");
            }
            this.codigo = codigo;
            this.nome = nome;
        }


        public ProdutoBuilder comValor(BigDecimal valor){
            this.valor = valor;
            return this;
        }

        public Produto build(){
            return new Produto(this);
        }

        public BigDecimal getValor() {
            return valor;
        }

        public String getNome() {
            return nome;
        }

        public Long getCodigo() {
            return codigo;
        }
    }
}
