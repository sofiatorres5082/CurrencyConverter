package com.currencyconverter;

import com.currencyconverter.api.ExchangeRateApiClient;

public class Main {

    public static void main(String[] args) {

        ExchangeRateApiClient client = new ExchangeRateApiClient();

        try {

            String endpoint = "USD";
            System.out.println("Llamando a: " + client.getApiUrl() + endpoint);
            String response = client.get(endpoint);
            System.out.println("Respuesta: " + response);

        } catch (Exception e) {

            System.err.println("Error al llamar a la API:");
            e.printStackTrace();

        }

    }
}