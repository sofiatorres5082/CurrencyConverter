package com.currencyconverter.service;

import com.currencyconverter.api.ExchangeRateApiClient;
import com.currencyconverter.model.Currency;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CurrencyService {
    private final ExchangeRateApiClient apiClient;
    private final Gson gson;

    private static final Set<String> FILTRO_MONEDAS = Set.of("ARS", "BOB", "BRL", "CLP", "COP", "USD");

    public CurrencyService() {
        this.apiClient = ExchangeRateApiClient.getInstance();
        this.gson = new Gson();
    }

    public Currency getCurrencyData(String baseCurrency) {
        try {
            String jsonResponse = apiClient.get(baseCurrency);

            if (jsonResponse == null || jsonResponse.isEmpty()) {
                System.err.println("La respuesta de la API está vacía.");
                return null;
            }

            Currency moneda = gson.fromJson(jsonResponse, Currency.class);

            Map<String, Double> conversionRatesFiltradas = filtrarMonedas(moneda.getConversionRates());

            moneda.setConversionRates(conversionRatesFiltradas);

            return moneda;

        } catch (IOException e) {
            System.err.println("Error de red al obtener los datos de la API: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.err.println("Error al procesar los datos de la API: " + e.getMessage());
            return null;
        }


    }

    private Map<String, Double> filtrarMonedas(Map<String, Double> conversionRates) {
        Map<String, Double> conversionRatesFiltradas = new HashMap<>();

        for (Map.Entry<String, Double> entry : conversionRates.entrySet()) {
            if (FILTRO_MONEDAS.contains(entry.getKey())) {
                conversionRatesFiltradas.put(entry.getKey(), entry.getValue());
            }
        }

        return conversionRatesFiltradas;
    }

    public double convertir(String baseCurrency, String targetCurrency, double amount) {
        Currency currencyData = getCurrencyData(baseCurrency);

        if (currencyData != null) {
            Map<String, Double> conversionRates = currencyData.getConversionRates();

            if (conversionRates.containsKey(targetCurrency)) {
                double conversionRate = conversionRates.get(targetCurrency);
                return amount * conversionRate;
            } else {
                System.err.println("Moneda objetivo no encontrada.");
            }
        } else {
            System.err.println("No se pudo obtener la data de la moneda base.");
        }

        return -1;
    }
}
