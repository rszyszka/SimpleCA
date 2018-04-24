/*
 * Copyright (C) 2018 Szysz
 */
package viewer;

import automata_1.Cell;

/**
 *
 * @author Szysz
 */
public class ConsoleCellViewer implements CellViewer {

    @Override
    public void view(Cell cell, int i, int iteration) {
        if (cell.getStatus() == 1) {
            System.out.print("*");
        } else {
            System.out.print(" ");
        }
    }

}
