package com.dgm.dio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Desafio
 * A nutricionista Juliana Alcantra é uma excelente profissional de sua área. Em determinado dia, ela foi entrevistada
 * ao vivo para um jornal da cidade. No entanto, ficou um pouco nervosa na hora, e diante da situação, sua fala ficou
 * um pouco distorcida, repetindo o final de cada palavra após dizer a mesma. Para que isso não aconteça novamente,
 * ela precisa da sua ajuda para escrever um programa que omita a parte repetida, de modo que as palavras
 * sejam pronunciadas como deveriam ser.
 * <p>
 * Escreva um programa que, dada uma palavra errada, a mesma seja corrigida.
 * <p>
 * Entrada
 * Haverá diversos casos de teste. Cada caso de teste é formado por uma palavra, de, no máximo, 30 caracteres,
 * dita da forma errada. A entrada termina com fim de arquivo.
 * <p>
 * Saída
 * Para cada caso de teste, escreva a palavra devidamente corrigida. Analise os exemplos para verificar o padrão, de
 * modo a consertar todos os casos.
 */
public class EntrevistaEmbaracosa {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String palavra;
        while ((palavra = br.readLine()) != null) {
            int size = palavra.length();

            String tempPalavraFora = "";
            for (int i = 0, l = palavra.length() - 1; i < palavra.length(); i++, l--) {
                tempPalavraFora = tempPalavraFora + new StringBuilder(palavra).reverse().charAt(i);

                String tempPalavraInterna = "";
                for (int j = palavra.length() - 1 - tempPalavraFora.length(), k = 0; j >= 0 && k <= i; k++, j--) {
                    tempPalavraInterna = tempPalavraInterna + palavra.charAt(j);
                }

                if (tempPalavraFora.equals(tempPalavraInterna)) {
                    size = l;
                }
            }
            System.out.println(palavra.substring(0, size));
        }
    }
}