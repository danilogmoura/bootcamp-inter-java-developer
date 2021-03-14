package com.dgm.dio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
