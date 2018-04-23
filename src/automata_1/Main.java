/*
 * Copyright (C) 2018 Szysz
 */
package automata_1;

/**
 *
 * @author Szysz
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int rule = 129;
        int iterations = 100;
        int tab[] = {0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0};

        CellularAutomat ca = new CellularAutomat(tab, tab.length, rule);
        ca.view();
        for (int i = 0; i < iterations; i++) {
            ca.nextIteration();
        }
        System.out.println(73/5);
        System.out.println(5*14);
    }
}