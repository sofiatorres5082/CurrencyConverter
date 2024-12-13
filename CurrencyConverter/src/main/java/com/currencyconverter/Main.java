package com.currencyconverter;

import com.currencyconverter.model.Currency;
import com.currencyconverter.service.CurrencyService;

public class Main {
    public static void main(String[] args) {
        CurrencyService service = new CurrencyService();

        // Obtener datos de la API para una moneda base
        Currency moneda = service.getCurrencyData("USD");

        // Mostrar las tasas de conversión
        if (moneda != null) {
            System.out.println("Base Currency: " + moneda.getBaseCode());
            System.out.println("Conversion Rates:");
            moneda.getConversionRates().forEach((currency, rate) ->
                    System.out.println(currency + ": " + rate));
        } else {
            System.out.println("No se pudieron obtener los datos.");
        }

        double cantidadConvertida = service.convertir("USD", "ARS", 100);

        if (cantidadConvertida != -1) {
            System.out.println("100 USD son " + cantidadConvertida + " ARS.");
        } else {
            System.out.println("Error al realizar la conversión.");
        }
    }
}
