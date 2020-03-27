package main.model.simulation;

import main.model.Space;
import main.model.bc.BoundaryCondition;

import java.util.ArrayList;

public class OrderedAsyncUpdateByteRulesSimulation extends ByteRulesSimulation {

    protected ArrayList<Integer> cellNumbers;


    public OrderedAsyncUpdateByteRulesSimulation(int rule, Space space, BoundaryCondition bc) {
        super(rule, space, bc);
        cellNumbers = new ArrayList<>(space.getSize());
        for (int i = 0; i < space.getSize(); i++) {
            cellNumbers.add(i);
        }
    }


    @Override
    protected void setCellNewStatus(int currentCellPos, int newStatus) {
        space.getCell(currentCellPos).setStatus(newStatus);
    }


    @Override
    public void nextIteration() {
        cellNumbers.forEach(i -> determineCellNewStatus(i - 1, i, i + 1));
    }

}
