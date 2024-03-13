package br.com.alura;

import java.math.BigDecimal;

public class AppBanco {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("João");
        Conta conta = new Conta(cliente, new BigDecimal("150"));
        var operacao = new OperacaoSaque(conta, new BigDecimal("150"));


        operacao.executa();
        operacao.executa();
        Thread thread = new Thread((Runnable) operacao);
    }
}
