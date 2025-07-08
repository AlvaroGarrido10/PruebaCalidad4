package com.practica;

import java.util.logging.Logger;

public class MainApp {

    private static final Logger logger = Logger.getLogger(MainApp.class.getName());

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        int suma = calc.sumar(10, 5);
        int resta = calc.restar(10, 4);
        int multi = calc.multiplicar(6, 7);
        int division = calc.dividir(20, 4);

        logger.info(() -> String.format("Suma: %d", suma));
        logger.info(() -> String.format("Resta: %d", resta));
        logger.info(() -> String.format("Multiplicación: %d", multi));
        logger.info(() -> String.format("División: %d", division));
    }
}
