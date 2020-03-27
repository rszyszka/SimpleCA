/*
 * Copyright (C) 2018 Szysz
 */
package main.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import main.model.Cell;
import main.model.GuiCellViewer;
import main.model.SimpleCellularAutomatonRulesSimulation;
import main.model.Space;
import main.model.bc.BoundaryCondition;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

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
    private Label info;
    @FXML
    private ScrollBar scrollBar;
    @FXML
    private Label cellSize;
    @FXML
    private ScrollBar probabilityScrollBar;
    @FXML
    private Label probabilityLabel;
    @FXML
    private ComboBox<BoundaryCondition.Type> comboBox;
    @FXML
    private CheckBox checkBox;
    private Space space;


    public void buttonAction() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        int cellSize = (int) scrollBar.getValue();
        int spaceSize = (int) canvas.getWidth() / cellSize;
        GuiCellViewer cellViewer = new GuiCellViewer(this, (int) scrollBar.getValue());

        try {
            info.setText("");
            int rule = Integer.parseInt(textField.getText().trim());
            space = new Space(spaceSize);
            determineRandomDistribution();
            SimpleCellularAutomatonRulesSimulation automaton = new SimpleCellularAutomatonRulesSimulation(
                    space, rule, BoundaryCondition.getInstance(comboBox.getValue(), space)
            );

            for (int i = 0; i < spaceSize; i++) {
                cellViewer.viewSpace(space, i);
                automaton.nextIteration();
            }

        } catch (NumberFormatException nfe) {
            info.setText("Give number only");
        }
    }

    private void determineRandomDistribution() {
        if (checkBox.isSelected()) {
            double probability = probabilityScrollBar.getValue();
            for (Cell cell : space.getCells()) {
                if (Math.random() < probability) {
                    cell.setStatus(1);
                }
            }
        } else {
            space.getCell(space.getSize() / 2).setStatus(1);
        }
    }


    public Canvas getCanvas() {
        return canvas;
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cellSize.setText(String.valueOf((int) scrollBar.getValue()));
        scrollBar.valueProperty().addListener((observable, oldValue, newValue) -> {
            cellSize.setText(String.valueOf((int) scrollBar.getValue()));
        });
        probabilityLabel.setText(String.valueOf(probabilityScrollBar.getValue()));
        probabilityScrollBar.valueProperty().addListener((observable, oldValue, newValue) -> {
            double value = BigDecimal.valueOf(probabilityScrollBar.getValue()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            probabilityLabel.setText(String.valueOf(value));
        });
        probabilityScrollBar.setDisable(true);
        checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            probabilityScrollBar.setDisable(oldValue);
        });
        comboBox.getItems().addAll(BoundaryCondition.Type.values());
        comboBox.getSelectionModel().selectFirst();
    }

}
