package com.dgm.dio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Desafio
 * Pedro e Fernando são os desenvolvedores em uma stratup e vão desenvolver o novo sistema de cadastro, e pediram a sua
 * ajuda. Sua task é fazer o código que valide as senhas que são cadastradas, para isso você deve atentar aos requisitos
 * a seguir:
 *
 * A senha deve conter, no mínimo, uma letra maiúscula, uma letra minúscula e um número;
 * A mesma não pode ter nenhum caractere de pontuação, acentuação ou espaço;
 * Além disso, a senha pode ter de 6 a 32 caracteres.
 *
 * Entrada
 * A entrada contém vários casos de teste e termina com final de arquivo. Cada linha tem uma string S, correspondente
 * a senha que é inserida pelo usuário no momento do cadastro.
 *
 * Saída
 * A saída contém uma linha, que pode ser “Senha valida.”, caso a senha tenha cada item dos requisitos solicitados
 * anteriormente, ou “Senha invalida.”, se um ou mais requisitos não forem atendidos.
 */

public class ValidadorDesenhas {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String password;

            while ((password = br.readLine()) != null) {
                boolean isValid = password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,32}$");

                if (!isValid) { //complete o if de acordo com suas variaveis
                    System.out.println("Senha invalida.");
                } else {
                    System.out.println("Senha valida.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
