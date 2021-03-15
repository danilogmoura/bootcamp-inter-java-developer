package com.dgm.dio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Pense um número positivo n. Agora me diga um divisor A de n. Agora me dê um outro número B que não seja divisor de n.
 * Agora um múltiplo C. E um não múltiplo D. O número que você pensou é...
 *
 * Parece um truque de mágica, mas é matemática! Será que, conhecendo os números A, B, C e D, você consegue descobrir
 * qual era o número original n? Note que pode existir mais de uma solução!
 *
 * Neste problema, dados os valores de A, B, C e D, você deve escrever um programa que determine qual o menor número n
 * que pode ter sido pensado ou concluir que não existe um valor possível.
 *
 * Entrada
 * A entrada consiste de uma única linha que contém quatro números inteiros A, B, C, e D, como
 * descrito acima (1 ≤ A, B, C, D ≤ 109).
 *
 * Saída
 * Seu programa deve produzir uma única linha. Caso exista pelo menos um número n para os quais A, B, C e D façam
 * sentido, a linha deve conter o menor n possível. Caso contrário, a linha deve conter -1.
 */

public class Divisores {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //declare suas variaveis
        // numero 4
        int a = Integer.parseInt(st.nextToken()); //2
        int b = Integer.parseInt(st.nextToken());  //12
        int c = Integer.parseInt(st.nextToken());  //8
        int d = Integer.parseInt(st.nextToken());  //2
        br.close();

        //declare suas variaveis com o valor correto
        int n = -1;
        //2 12 8 2
        //continue o codigo
        if (c % a == 0) {
            int sqrt = (int) Math.sqrt(c);

            for (int i = 1; i <= sqrt * a; i++) {
                n = a * i;
                if (n % b != 0 && d % n != 0 && c % n == 0) {
                    break;
                }
            }
        }
        System.out.println(n);
    }
}
