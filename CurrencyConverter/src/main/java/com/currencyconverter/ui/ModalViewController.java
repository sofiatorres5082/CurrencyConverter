package com.currencyconverter.ui;

import com.currencyconverter.model.Historial;
import javafx.fxml.FXML;

import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.util.List;

public class ModalViewController {
    @FXML
    private Label titleLabel;
    @FXML
    private ListView<String> listView;

    public void initialize() {

    }

    public void setHistorial(List<Historial> historialList) {
        for (Historial h : historialList) {
            listView.getItems().add(h.toString());
        }
    }

}
