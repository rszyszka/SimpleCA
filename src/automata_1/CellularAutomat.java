/*
 * Copyright (C) 2018 Szysz
 */
package automata_1;

import java.util.Arrays;
import viewer.CellViewer;

/**
 *
 * @author Szysz
 */
public class CellularAutomat {

    private final Cell automata[];
    private final int size;
    
    private int iteration;

    private final CellViewer viewers[];

    public CellularAutomat(int size, int rule, CellViewer viewers[]) {
        
        this.iteration = 0;
        
        int tab[] = new int[size];
        Arrays.fill(tab, 0);
        tab[size/2] = 1;
        
        this.viewers = viewers;
        this.size = size;

        automata = new Cell[size];

        for (int i = 0; i < size; i++) {

            if (i == 0) {
                automata[i] = new Cell(tab[i], tab[size - 1], tab[i + 1], rule);
            } else if (i == size - 1) {
                automata[i] = new Cell(tab[i], tab[i - 1], tab[0], rule);
            } else {
                automata[i] = new Cell(tab[i], tab[i - 1], tab[i + 1], rule);
            }
        }
    }

    public void view() {
        for (int i = 0; i < size; i++) {
            for (CellViewer cv : viewers) {
                cv.view(automata[i], i, iteration);
            }
        }
        System.out.println("");
        iteration++;
    }

    public void nextIteration() {

        for (int i = 0; i < size; i++) {
            automata[i].nextIteration();
        }
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                automata[i].update(automata[size - 1], automata[i + 1]);
            } else if (i == size - 1) {
                automata[i].update(automata[i - 1], automata[0]);
            } else {
                automata[i].update(automata[i - 1], automata[i + 1]);
            }
            for (CellViewer cv : viewers) {
                cv.view(automata[i], i, this.iteration);
            }
        }
        System.out.println("");
        this.iteration++;
    }
}
