package com.currencyconverter.api;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExchangeRateApiClient {
    private static ExchangeRateApiClient instance;
    private final String apiUrl;

    private ExchangeRateApiClient() {
        Dotenv dotenv = Dotenv.load();
        this.apiUrl = dotenv.get("API_URL");
        if (apiUrl == null || apiUrl.isEmpty()) {
            throw new IllegalStateException("La variable API_URL no está configurada en el archivo .env.");
        }
    }

    public static synchronized ExchangeRateApiClient getInstance() {
        if (instance == null) {
            instance = new ExchangeRateApiClient();
        }
        return instance;
    }

    public String get(String endpoint) throws Exception {
        String fullUrl = apiUrl + endpoint;
        URL url = new URL(fullUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Error en la solicitud: Código " + responseCode);
        }

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        }
    }
}
