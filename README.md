# CurrencyConverter

Este es un proyecto para convertir entre distintas monedas utilizando tasas de cambio en tiempo real obtenidas de una API. El objetivo es ofrecer una experiencia interactiva de conversión con una interfaz gráfica utilizando JavaFX.

## Estructura del Proyecto

La estructura del proyecto es la siguiente:

```bash
src/main/java
├── com.coinconverter
│   ├── api         // Clases relacionadas con la API (e.g., Cliente para realizar solicitudes)
│   ├── model       // Clases que representan datos (e.g., Moneda, Tasa de Cambio)
│   ├── service     // Lógica de negocio (e.g., solicitudes a la API, conversión)
│   ├── ui          // Interfaz con el usuario (e.g., JavaFX)
│   └── Main.java   // Clase principal que inicia la aplicación
```

- **`api/`**: Contiene las clases que gestionan las solicitudes HTTP hacia la API de tasas de cambio.
- **`model/`**: Aquí se encuentran las clases que modelan los datos, como `Moneda` y `Tasa de Cambio`.
- **`service/`**: Se encargan de la lógica de negocio, como la conversión entre monedas y la obtención de tasas de cambio.
- **`ui/`**: Contiene los archivos de la interfaz gráfica con JavaFX para interactuar con el usuario.
- **`Main.java`**: La clase principal que arranca la aplicación.

## Requisitos

- **Java 11** o superior
- **Maven**
- **Gson** para trabajar con respuestas JSON
- **Postman** (para probar la API si es necesario)


