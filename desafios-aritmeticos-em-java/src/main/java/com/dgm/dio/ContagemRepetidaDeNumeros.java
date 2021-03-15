package com.dgm.dio;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Entrada
 * A primeira linha de entrada contem um único inteiro N, que indica a quantidade de valores que serão lidos
 * para X (1 ≤ N ≤ 2000) logo em seguida. Com certeza cada número não aparecerá mais do que 20 vezes na entrada de dados.
 *
 * Saída
 * Imprima a saída de acordo com o exemplo fornecido abaixo, indicando quantas vezes cada um deles aparece na entrada
 * por ordem crescente de valor.
 */
public class ContagemRepetidaDeNumeros {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            sc.useLocale(Locale.ENGLISH);
            Locale.setDefault(new Locale("en", "US"));

            ArrayList<Integer> numemosList = new ArrayList<>();

            int entrada = sc.nextInt();
            while (entrada-- > 0)
                numemosList.add(sc.nextInt());

            numemosList.stream()
                    .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()))
                    .forEach((key, value) -> System.out.printf("%d aparece %d vez(es)\n", key, value));
        }
    }
}