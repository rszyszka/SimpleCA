/*
 * Copyright (C) 2018 Szysz
 */
package viewer;

import automata_1.Cell;
import gui.FXMLController;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author Szysz
 */
public class GuiCellViewer implements CellViewer {

    FXMLController controller;
    int size;

    public GuiCellViewer(FXMLController controller, int size) {
        this.controller = controller;
        this.size = size;

    }

    @Override
    public void view(Cell cell, int i, int iteration) {
        GraphicsContext gc = controller.getCanvas().getGraphicsContext2D();

        if (cell.getStatus() == 1) {
            gc.fillRect(size * i, size * iteration, size, size);
        }
    }
}
