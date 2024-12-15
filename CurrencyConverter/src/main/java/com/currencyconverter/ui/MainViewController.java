package com.currencyconverter.ui;

import com.currencyconverter.service.CurrencyService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Arrays;

public class MainViewController {
    private final CurrencyService service = new CurrencyService();

    @FXML
    private ComboBox<String> comboBase;
    @FXML
    private ComboBox<String> comboTarget;
    @FXML
    private TextField inputAmount;
    @FXML
    private Label resultLabel;
    @FXML
    private Button convertButton;
    @FXML
    private Button copyButton;

    @FXML
    private void initialize() {
        comboBase.getItems().addAll(Arrays.asList("USD (Dólares)", "BOB (Bolivianos)", "BRL (Reales)", "ARS (Pesos Argentinos)", "CLP (Pesos Chilenos)", "COP (Pesos Colombianos)"));
        comboTarget.getItems().addAll(Arrays.asList("USD (Dólares)", "BOB (Bolivianos)", "BRL (Reales)", "ARS (Pesos Argentinos)", "CLP (Pesos Chilenos)", "COP (Pesos Colombianos)"));

        comboBase.setValue("USD (Dólares)");
        comboTarget.setValue("ARS (Pesos Argentinos)");

        convertButton.setOnAction(e -> realizarConversion());
        copyButton.setOnAction(e -> copiarResultado());
    }

    @FXML
    private void realizarConversion() {
        String base = comboBase.getValue().split(" ")[0];
        String target = comboTarget.getValue().split(" ")[0];

        try {
            double amount = Double.parseDouble(inputAmount.getText());
            double result = service.convertir(base, target, amount);

            if (result != -1) {
                resultLabel.setText(amount + " " + base + " son " + result + " " + target + ".");
            } else {
                resultLabel.setText("Error al realizar la conversión.");
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Por favor, ingrese una cantidad válida.");
        }
    }

    @FXML
    private void copiarResultado() {
        String resultText = resultLabel.getText();

        if (resultText != null && resultText.contains("son")) {
            StringSelection stringSelection = new StringSelection(resultText);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
            resultLabel.setText("Resultado copiado al portapapeles!");
        } else {
            resultLabel.setText("No hay nada para copiar.");
        }
    }
}
