package com.dgm.dio;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculadoraTest {

    @Test
    public void testSomar() {
        Calculadora calculadora = new Calculadora();
        int soma = calculadora.somar("1+1+3");

        assertEquals(5, soma);
    }

    @Test
    public void testeSomarComMock() {
        Calculadora calculadora = mock(Calculadora.class);

        when(calculadora.somar("1+2")).thenReturn(10);

        int resultado = calculadora.somar("1+2");

        assertEquals(10, resultado);
    }
}