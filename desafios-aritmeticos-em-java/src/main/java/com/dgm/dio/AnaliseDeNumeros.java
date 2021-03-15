package com.dgm.dio;

import java.io.IOException;
import java.util.Scanner;

/**
 * Desafio
 * Você deve fazer a leitura de 5 valores inteiros. Em seguida mostre quantos valores informados são pares, quantos
 * valores informados são ímpares, quantos valores informados são positivos e quantos valores informados são negativos.
 *
 * Entrada
 * Você receberá 5 valores inteiros.
 *
 * Saída
 * Exiba a mensagem conforme o exemplo de saída abaixo, sendo uma mensagem por linha e não esquecendo o final de
 * linha após cada uma.
 */
public class AnaliseDeNumeros {

    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        //declare suas variaveis corretamente
        int qtdPares = 0;
        int qtdImpares = 0;
        int qtdPositivos = 0;
        int qtdNegativos = 0;
        int valor;

        //continue a solução
        while (leitor.hasNextInt()) {
            valor = leitor.nextInt();

            if (Math.abs(valor % 2) == 0) {
                qtdPares++;
            } else {
                qtdImpares++;
            }

            if (valor > 0) {
                qtdPositivos++;
            } else if (valor < 0) {
                qtdNegativos++;
            }

        }

        //insira suas variaveis corretamente
        System.out.println(qtdPares + " valor(es) par(es)");
        System.out.println(qtdImpares + " valor(es) impar(es)");
        System.out.println(qtdPositivos + " valor(es) positivo(s)");
        System.out.println(qtdNegativos + " valor(es) negativo(s)");
    }
}
