/*
 * Copyright (C) 2018 Szysz
 */
package gui;

import automata_1.CellularAutomat;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import viewer.CellViewer;
import viewer.ConsoleCellViewer;
import viewer.GuiCellViewer;

/**
 * FXML Controller class
 *
 * @author Szysz
 */
public class FXMLController implements Initializable {

    @FXML
    private Canvas canvas;
    @FXML
    private TextField textField;
    @FXML
    private Button button;
    @FXML
    private Label info;
    @FXML
    private ScrollBar scrollBar;
    @FXML
    private Label cellSize;
    @FXML
    private ComboBox<String> comboBox;

    CellularAutomat ca;

    public void buttonAction() {

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        try {
            int rule = Integer.parseInt(textField.getText().trim());
            info.setText("");

            CellViewer[] cv = {
                new GuiCellViewer(this, (int) scrollBar.getValue()), //new ConsoleCellViewer()
            };

            ca = new CellularAutomat((int) canvas.getWidth() / (int) scrollBar.getValue(), rule, cv);

            view();

        } catch (NumberFormatException nfe) {
            info.setText("Give number only");
        }
    }

    public void dragAction() {
        cellSize.setText(String.valueOf((int) scrollBar.getValue()));
        // System.out.println(scrollBar.getValue());

    }

    public void view() {
        ca.view();
        for (int i = 0; i < (int) canvas.getWidth() / (int) scrollBar.getValue(); i++) {
            ca.nextIteration();
        }
    }

    public Canvas getCanvas() {
        return canvas;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cellSize.setText(String.valueOf((int) scrollBar.getValue()));
        scrollBar.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            cellSize.setText(String.valueOf((int) scrollBar.getValue()));
        });

        comboBox.getItems().addAll(
                "Zamknięty",
                "Periodyczny"
        );
        comboBox.getSelectionModel().selectFirst();
    }

}
