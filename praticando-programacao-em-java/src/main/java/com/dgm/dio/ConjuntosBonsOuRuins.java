package com.dgm.dio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Desafio
 * Nesse algoritmo você deverá descobrir se um conjunto de palavras é bom ou ruim. Por definição, um conjunto é bom
 * quando nenhuma palavra desse conjunto é um prefixo de outra palavra. Caso contrário, é considerado um conjunto ruim.
 *
 * Por exemplo, {dbc, dae, dbcde} é um conjunto ruim, pois dbc é um prefixo de dbcde. Quando duas palavras são
 * idênticas, definimos como uma sendo prefixo da outra.
 *
 * Entrada
 * A entrada contém vários casos de teste. A primeira linha de cada caso de teste terá um inteiro N (1 ≤ N ≤ 10⁵),
 * que representa a quantidade de palavras no conjunto. Segue então N linhas, cada uma tendo uma palavra de no máximo
 * 100 letras minúsculas. A entrada termina quando N = 0 e não deve ser processada.
 *
 * Saída
 * Para cada caso de teste, você deverá imprimir "Conjunto Bom", ou "Conjunto Ruim", conforme explicado acima.
 *
 */
public class ConjuntosBonsOuRuins {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {

            Integer qtdPalavras;
            while ((qtdPalavras = Integer.parseInt(br.readLine())) != 0) {
                List<String> palavras = new ArrayList<>();
                for (int i = 0; i < qtdPalavras; i++) {
                    palavras.add(br.readLine().replaceAll("\\s+", ""));
                }

                final List<String> atualPalavras = palavras.stream().distinct().collect(Collectors.toList());

                if (atualPalavras.size() != palavras.size()) {
                    System.out.println("Conjunto Ruim");
                    continue;
                }

                boolean ruim = atualPalavras.stream().anyMatch(it ->
                        atualPalavras.stream().anyMatch(s -> !s.equals(it) && s.startsWith(it))
                );

                System.out.println(ruim ? "Conjunto Ruim" : "Conjunto Bom");
            }
        }
    }
}
