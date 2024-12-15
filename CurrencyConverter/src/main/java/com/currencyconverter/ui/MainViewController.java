package com.currencyconverter.ui;

import com.currencyconverter.model.Historial;
import com.currencyconverter.service.CurrencyService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainViewController {
    private final CurrencyService service = new CurrencyService();

    private List<Historial> historialList = new ArrayList<>();

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
    private Button historyButton;


    @FXML
    private void initialize() {
        comboBase.getItems().addAll(Arrays.asList("USD (Dólares)", "BOB (Bolivianos)", "BRL (Reales)", "ARS (Pesos Argentinos)", "CLP (Pesos Chilenos)", "COP (Pesos Colombianos)"));
        comboTarget.getItems().addAll(Arrays.asList("USD (Dólares)", "BOB (Bolivianos)", "BRL (Reales)", "ARS (Pesos Argentinos)", "CLP (Pesos Chilenos)", "COP (Pesos Colombianos)"));

        comboBase.setValue("USD (Dólares)");
        comboTarget.setValue("ARS (Pesos Argentinos)");

        convertButton.setOnAction(e -> realizarConversion());
        copyButton.setOnAction(e -> copiarResultado());

        ImageView historyIcon = new ImageView(new Image(getClass().getResourceAsStream("/icons/history-icon.png")));
        historyIcon.setFitWidth(30);
        historyIcon.setFitHeight(30);

        historyButton.setGraphic(historyIcon);
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

                historialList.add(new Historial(base, target, amount, result));
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

    @FXML
    public void mostrarHistorial(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ModalView.fxml"));
            Parent root = loader.load();

            ModalViewController modalController = loader.getController();

            modalController.setHistorial(historialList);

            Stage modalStage = new Stage();
            modalStage.initModality(Modality.APPLICATION_MODAL);
            modalStage.setTitle("Historial de Conversiones");

            Scene scene = new Scene(root);
            modalStage.setScene(scene);
            modalStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
