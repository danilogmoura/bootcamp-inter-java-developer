package com.dgm.dio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class AbreviandoPosts {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> mensagem = new ArrayList<>();
        HashMap<String, String> abreviacoes = new HashMap<>();

        String line;
        while ((line = br.readLine()) != null && !line.equals(".")) {
            StringTokenizer st = new StringTokenizer(line);

            while (st.hasMoreTokens()) {
                String palavra = st.nextToken();
                mensagem.add(palavra);

                String abreviacao = palavra.substring(0, 1).concat(".");
                if (palavra.length() <= 2 || abreviacoes.containsKey(abreviacao)) {
                    continue;
                }
                abreviacoes.put(abreviacao, palavra);
            }
        }

        AtomicInteger count = new AtomicInteger(0);
        mensagem = mensagem.stream().map(it -> {
            if (abreviacoes.containsValue(it)) {
                count.incrementAndGet();
                return it.substring(0, 1).concat(".");
            }
            return it;
        }).collect(Collectors.toList());

        System.out.println(String.join(" ", mensagem));
        System.out.println(count);
        abreviacoes.forEach((key, value) -> System.out.println(key + " = " + value));
    }
}

