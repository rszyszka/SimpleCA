/*
 * Copyright (C) 2018 Szysz
 */
package main.model;

import main.model.bc.BoundaryCondition;

/**
 * @author Szysz
 */
public class SimpleCellularAutomatonRulesSimulation {
    private final int size;
    private final int rule;
    private Space space;
    private Space nextIterationSpace;
    private BoundaryCondition bc;

    public SimpleCellularAutomatonRulesSimulation(Space space, int rule, BoundaryCondition bc) {
        this.space = space;
        this.nextIterationSpace = new Space(space);
        this.size = space.getSize();
        this.rule = rule;
        this.bc = bc;
    }

    public void nextIteration() {
        for (int i = 0; i < size; i++) {
            setNextIterationCellNewStatus(i - 1, i, i + 1);
        }
        space.copyCellsState(nextIterationSpace);
    }

    private void setNextIterationCellNewStatus(int leftNeighbourPos, int currentCellPos, int rightNeighbourPos) {
        int leftCellStatus = bc.getCorrectedStatus(leftNeighbourPos);
        int currentCellStatus = space.getCell(currentCellPos).getStatus();
        int rightCellStatus = bc.getCorrectedStatus(rightNeighbourPos);
        nextIterationSpace.getCell(currentCellPos).setStatus(determineNewStatus(leftCellStatus, currentCellStatus, rightCellStatus));
    }


    private int determineNewStatus(int left, int current, int right) {
        if (left == 0 && current == 0 && right == 0) {
            return getBit(rule, 0);
        } else if (left == 0 && current == 0 && right == 1) {
            return getBit(rule, 1);
        } else if (left == 0 && current == 1 && right == 0) {
            return getBit(rule, 2);
        } else if (left == 0 && current == 1 && right == 1) {
            return getBit(rule, 3);
        } else if (left == 1 && current == 0 && right == 0) {
            return getBit(rule, 4);
        } else if (left == 1 && current == 0 && right == 1) {
            return getBit(rule, 5);
        } else if (left == 1 && current == 1 && right == 0) {
            return getBit(rule, 6);
        } else if (left == 1 && current == 1 && right == 1) {
            return getBit(rule, 7);
        }
        return 0;
    }

    private int getBit(int n, int k) {
        return (n >> k) & 1;
    }

}
