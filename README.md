# Conversor de Monedas

Este es un proyecto para convertir entre distintas monedas utilizando tasas de cambio en tiempo real obtenidas de una API (ExchangeRate). El objetivo es ofrecer una experiencia interactiva de conversión con una interfaz gráfica utilizando JavaFX.

---


☆ ───── **Características** ───── ☆

- `Conversión de Monedas`: Convierte entre monedas como ARS, BOB, BRL, CLP, COP y USD. 
- `Historial de Conversiones`: Registra y muestra un historial de las conversiones realizadas en la sesión.
- `Interfaz Intuitiva`: Diseño moderno con JavaFX que incluye funcionalidades como copiado de resultados al portapapeles.  
- `Filtrado de Tasas`: Muestra únicamente tasas relevantes.

---


☆ ───── **Tecnologías** ───── ☆

| Herramienta   | Uso         |
|---------------|-------------|
| 🖥️ **Java 11+**  | Lenguaje principal. |
| 🎨 **JavaFX:** | Framework para desarrollar la interfaz gráfica |
| 🌐 **Dotenv** | Manejo de variables de entorno sensibles. |
| 🔧 **Gson**    | Para parseo de respuestas JSON. |
| 📦 **Maven**    | Para el manejo de dependencias. |

---


 ☆ ───── **Estructura del Proyecto** ───── ☆

La estructura del proyecto es la siguiente:

```bash
src/
├── com/
│   ├── currencyconverter/
│   │   ├── api/
│   │   │   └── ExchangeRateApiClient.java
│   │   ├── model/
│   │   │   ├── Currency.java
│   │   │   └── Historial.java
│   │   ├── service/
│   │   │   └── CurrencyService.java
│   │   └── ui/
│   │       ├── MainViewController.java
│   │       └── ModalViewController.java
│   └── Main.java
├── resources/
│   ├── fonts/
│   ├── icons/
│   ├── images/
│   ├── styles/
│   ├── MainView.fxml
│   └── ModalView.fxml
└── .env
```


---


☆ ───── **Capturas de Pantalla** ───── ☆

✨ **Interfaz del Conversor de Monedas**  

<p align="center">
  <img src="https://github.com/user-attachments/assets/49c91073-a47b-42dd-a6ef-150ca9c18c34" alt="Interfaz principal" width="45%" style="margin-right:10px;"/>
  <img src="https://github.com/user-attachments/assets/37706303-5cb7-418b-90ab-ccfdd60ae29f" alt="Historial de Conversiones" width="45%"/>
</p>

---


🚀 **Instalación y Uso**

1. **Clonar el repositorio:**  
   ```bash
   git clone https://github.com/tu-repo/conversor-monedas.git
   cd conversor-monedas
2. **Configurar las variables de entorno:**
   Crea un archivo .env en la raíz del proyecto y define tu url junto con la clave API para ExchangeRate
   ```bash
   API_URL=tu_url_con_clave_api
3. **Compilar y ejecutar el proyecto:**
   Utiliza tu IDE favorito (por ejemplo, IntelliJ IDEA o Eclipse) o ejecuta el proyecto con Maven/Gradle desde la línea de comandos.
  

  


