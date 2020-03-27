package main.model.simulation;

import main.model.Space;
import main.model.bc.BoundaryCondition;


public abstract class ByteRulesSimulation {

    protected final int size;
    protected final int rule;
    protected Space space;
    protected BoundaryCondition bc;


    public ByteRulesSimulation(int rule, Space space, BoundaryCondition bc) {
        this.size = space.getSize();
        this.rule = rule;
        this.space = space;
        this.bc = bc;
    }

    public static ByteRulesSimulation getInstance(int rule, Space space, BoundaryCondition bc, SimulationUpdateSchema type) {
        switch (type) {
            case ORDERED_ASYNC:
                return new OrderedAsyncUpdateByteRulesSimulation(rule, space, bc);
            case CYCLIC_ASYNC:
                return new CyclicAsyncUpdateByteRulesSimulation(rule, space, bc);
            case RANDOM_ORDERED_ASYNC:
                return new RandomOrderedAsyncUpdateByteRulesSimulation(rule, space, bc);
            default:
                return new SynchronousUpdateByteRulesSimulation(rule, space, bc);
        }
    }

    public abstract void nextIteration();


    protected void determineCellNewStatus(int leftNeighbourPos, int currentCellPos, int rightNeighbourPos) {
        int leftCellStatus = bc.getCorrectedStatus(leftNeighbourPos);
        int currentCellStatus = space.getCell(currentCellPos).getStatus();
        int rightCellStatus = bc.getCorrectedStatus(rightNeighbourPos);
        setCellNewStatus(currentCellPos, determineNewStatus(leftCellStatus, currentCellStatus, rightCellStatus));
    }

    protected abstract void setCellNewStatus(int currentCellPos, int newStatus);


    protected int determineNewStatus(int left, int current, int right) {
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
