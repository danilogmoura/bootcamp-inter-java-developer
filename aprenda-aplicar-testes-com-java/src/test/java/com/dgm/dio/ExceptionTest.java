package com.dgm.dio;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ExceptionTest {

    @Test(expected = IndexOutOfBoundsException.class)
    public void empty() {
        List<String> lista = new ArrayList<>();
        lista.add("Danilo");

        lista.get(0);
    }

    @Rule
    public ExpectedException thown = ExpectedException.none();

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldTestExceptionMessage() {
        List<Object> lista = new ArrayList<>();

        thown.expect(IndexOutOfBoundsException.class);
        thown.expectMessage("Index: 0, Size: 0");
        lista.get(0);
    }

    @Test
    public void testExceptionMessage() {
        try {
            new ArrayList<Object>().get(0);
            fail("Esperado que IndexOutOfBoundsException seja lançada");
        } catch (IndexOutOfBoundsException ex) {
            assertThat(ex.getMessage(), is("Index 0 out of bounds for length 0"));
        }
    }
}
