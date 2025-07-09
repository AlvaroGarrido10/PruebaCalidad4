package com.practica;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculadoraTest {

    @Test
    public void testSumar() {
        Calculadora calc = new Calculadora();
        assertEquals(8, calc.sumar(6, 3));
    }

    @Test
    public void testRestar() {
        Calculadora calc = new Calculadora();
        assertEquals(6, calc.restar(10, 4));
    }

    @Test
    public void testMultiplicar() {
        Calculadora calc = new Calculadora();
        assertEquals(42, calc.multiplicar(6, 7));
    }

    @Test
    public void testDividir() {
        Calculadora calc = new Calculadora();
        assertEquals(5, calc.dividir(20, 4));
    }

    @Test(expected = ArithmeticException.class)
    public void testDividirPorCero() {
        Calculadora calc = new Calculadora();
        calc.dividir(10, 0);
    }
}
