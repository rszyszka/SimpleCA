/*
 * Copyright (C) 2018 Szysz
 */
package automata_1;

/**
 *
 * @author Szysz
 */
public class CellularAutomat {

    private final Cell automata[];
    private final int size;

    public CellularAutomat(int tab[], int size, int rule) {
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
            automata[i].view();
        }
        System.out.println("");
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
            automata[i].view();
        }
        System.out.println("");
    }
}
