package com.currencyconverter.api;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExchangeRateApiClient {
    private final String apiUrl;

    // Constructor para inicializar la URL de la API
    public ExchangeRateApiClient() {
        Dotenv dotenv = Dotenv.load();
        this.apiUrl = dotenv.get("API_URL");
        if (apiUrl == null || apiUrl.isEmpty()) {
            throw new IllegalStateException("La variable API_URL no está configurada en el archivo .env.");
        }
    }

    // Método para realizar una solicitud GET a la API
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

    public String getApiUrl() {
        return apiUrl;
    }
}
