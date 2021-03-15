package com.dgm.dio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Desafio
 * Encontre a maior substring comum entre as duas strings informadas. A substring pode ser qualquer parte da string,
 * inclusive ela toda. Se não houver subseqüência comum, a saída deve ser “0”.
 * A comparação é case sensitive ('x' != 'X').
 *
 * Entrada
 * A entrada contém vários casos de teste. Cada caso de teste é composto por duas linhas, cada uma contendo uma string.
 * Ambas strings de entrada contém entre 1 e 50 caracteres ('A'-'Z','a'-'z' ou espaço ' '), inclusive, ou no mínimo uma
 * letra ('A'-'Z','a'-'z').
 *
 * Saída
 * O tamanho da maior subsequência comum entre as duas Strings.
 */

public class MaiorSubstring {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        String linha1, linha2, min, max; //declare suas variaveis aqui
        while ((linha1 = in.readLine()) != null) { // complete seu código
            linha2 = in.readLine();

            if (linha1.length() > linha2.length()) {
                max = linha1;
                min = linha2;
            } else {
                max = linha2;
                min = linha1;
            }

            int minLength = min.length();
            int maxS = minLength;
            boolean f = true;

            while (maxS > 0 && f) { //altere as variaveis, se achar necessario
                int diff = minLength - maxS;

                for (int i = 0; i <= diff; i++) { //complete o laco de repeticao
//                    System.out.println(min.substring(i, i + maxS));
                    if (max.contains(min.substring(i, i + maxS))) {
                        f = false;
                        maxS++;
                        break;
                    }
                }
                maxS--;
            }
            System.out.println(maxS);
        }
        out.close();
    }
}