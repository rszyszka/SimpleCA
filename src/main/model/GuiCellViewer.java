/*
 * Copyright (C) 2018 Szysz
 */
package main.model;

import javafx.scene.canvas.GraphicsContext;
import main.gui.FXMLController;

/**
 * @author Szysz
 */
public class GuiCellViewer {
    private FXMLController controller;
    private int size;

    public GuiCellViewer(FXMLController controller, int size) {
        this.controller = controller;
        this.size = size;

    }

    public void viewSpace(Space space, int iteration) {
        for (int i = 0; i < space.getSize(); i++) {
            view(space.getCell(i), i, iteration);
        }
    }


    public void view(Cell cell, int i, int iteration) {
        GraphicsContext gc = controller.getCanvas().getGraphicsContext2D();
        if (cell.getStatus() == 1) {
            gc.fillRect(size * i, size * iteration, size, size);
        }
    }
}
