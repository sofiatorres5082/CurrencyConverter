package com.currencyconverter.ui;

import com.currencyconverter.model.Historial;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class ModalViewController {
    @FXML
    private ListView<String> listView;

    public void setHistorial(List<Historial> historialList) {
        for (Historial h : historialList) {
            listView.getItems().add(h.toString());
        }
    }
}
