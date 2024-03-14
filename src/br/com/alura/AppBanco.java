package br.com.alura;

import java.math.BigDecimal;

public class AppBanco {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("João");
        Conta conta = new Conta(cliente, new BigDecimal("150"));
        var operacao = new OperacaoSaque(conta, new BigDecimal("150"));



        Thread saqueDoJoao = new Thread(operacao);
        Thread saqueDaMaria = new Thread(operacao);

        saqueDoJoao.start();
        saqueDaMaria.start();
        System.out.println( Thread.currentThread().getName());
        try {
            saqueDoJoao.join();
            saqueDaMaria.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Saldo final: " + conta.getSaldo());

    }
}
