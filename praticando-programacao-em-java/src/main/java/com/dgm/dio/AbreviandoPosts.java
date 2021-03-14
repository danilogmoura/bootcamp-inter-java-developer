package com.dgm.dio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * Desafio
 * Leonardo é um nômade digital e viaja pelo mundo programando em diferentes cafés das cidades por onde passa.
 * Recentemente, resolveu criar um blog, para compartilhar suas experiências e aprendizados com seus amigos.
 *
 * Para criação do blog, ele optou por utilizar uma ferramenta pronta, que há um limite de caracteres que se pode
 * escrever por dia, e Leonardo está preocupado que essa limitação, afinal, irá impedir de contar suas melhores
 * experiências. Para contornar esse problema, decidiu usar um sistema de abreviação de palavras em seus posts.
 *
 * O sistema de abreviações é simples e funciona da seguinte forma: para cada letra, é possível escolher uma palavra
 * que inicia com tal letra e que aparece no post. Uma vez escolhida a palavra, sempre que ela aparecer no post, ela
 * será substituída por sua letra inicial e um ponto, diminuindo assim o número de caracteres impressos na tela.
 *
 * Por exemplo, na frase: “hoje eu programei em Python”, podemos escolher a palavra “programei” para representar a
 * letra ‘p', e a frase ficará assim: “hoje eu p. em Python”, economizando assim sete caracteres. Uma mesma palavra
 * pode aparecer mais de uma vez no texto, e será abreviada todas as vezes. Note que, se após uma abreviação o número
 * de caracteres não diminuir, ela não deve ser usada, tal como no caso da palavra “eu” acima.
 *
 * Leonardo precisa que seu post tenha o menor número de caracteres possíveis, e por isso pediu a sua ajuda. Para cada
 * letra, escolha uma palavra, de modo que ao serem aplicadas todas as abreviações, o texto contenha o menor número de
 * caracteres possíveis.
 *
 * Entrada
 * Haverá diversos casos de teste. Cada caso de teste é composto de uma linha, contendo uma frase de até 10⁴
 * caracteres. A frase é composta de palavras e espaços em branco, e cada palavra é composta de letras
 * minúsculas ('a'-'z'), e contém entre 1 e 30 caracteres cada.
 *
 * O último caso de teste é indicado quando a linha dada conter apenas um “.”, o qual não deverá ser processado.
 *
 * Saída
 * Para cada caso de teste, imprima uma linha contendo a frase já com as abreviações escolhidas e aplicadas.
 *
 * Em seguida, imprima um inteiro N, indicando o número de palavras em que foram escolhidas uma letra para a abreviação
 * no texto. Nas próximas N linhas, imprima o seguinte padrão “C. = P”, onde C é a letra inicial e P é a palavra
 * escolhida para tal letra. As linhas devem ser impressas em ordem crescente da letra inicial.
 */

public class AbreviandoPosts {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String frase;
        while ((frase = br.readLine()) != null && !frase.equals(".")) {
            abreviar(frase);
        }
    }

    private static void abreviar(String frase) {
        final List<String> palavras = Arrays.asList(frase.split("\\s+"));

        final Map<String, Map.Entry<String, Palavra>> palavrasSelecionadas = palavras.stream()
                .filter(it -> it.length() > 2)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .map(it -> new Palavra(it.getKey(), it.getValue().intValue()))
                .collect(Collectors.toMap(it -> it.getAbreviacao(), Function.identity(), BinaryOperator.maxBy(Comparator.comparing(Palavra::getPontuacao))))
                .entrySet().stream().collect(Collectors.toMap(it -> it.getValue().getValor(), Function.identity()));

        final String fraseAlterada = palavras.stream().map(it -> {
            if (palavrasSelecionadas.containsKey(it)) {
                return palavrasSelecionadas.get(it).getValue().getAbreviacao();
            }
            return it;
        }).collect(Collectors.joining(" "));

        System.out.println(fraseAlterada);
        System.out.println(palavrasSelecionadas.size());
        palavrasSelecionadas.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(it -> System.out.println(it.getValue().getValue().getAbreviacao() + " = " + it.getKey()));
    }
}

class Palavra {

    private String valor;
    private int tamanho;
    private int ocorrencia;

    public Palavra(String valor, int ocorrencia) {
        this.valor = valor;
        this.tamanho = valor.length();
        this.ocorrencia = ocorrencia;
    }

    public String getValor() {
        return valor;
    }

    public String getAbreviacao() {
        return valor.substring(0, 1) + ".";
    }

    public int getPontuacao() {
        return (tamanho - 2) * ocorrencia;
    }
}