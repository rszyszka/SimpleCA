package main.model.simulation;

import main.model.Space;
import main.model.bc.BoundaryCondition;


public class SynchronousUpdateByteRulesSimulation extends ByteRulesSimulation {

    private Space nextIterationSpace;


    public SynchronousUpdateByteRulesSimulation(int rule, Space space, BoundaryCondition bc) {
        super(rule, space, bc);
        this.nextIterationSpace = new Space(space);
    }


    @Override
    public void nextIteration() {
        for (int i = 0; i < size; i++) {
            determineCellNewStatus(i - 1, i, i + 1);
        }
        space.copyCellsState(nextIterationSpace);
    }


    @Override
    protected void setCellNewStatus(int currentCellPos, int newStatus) {
        nextIterationSpace.getCell(currentCellPos).setStatus(newStatus);
    }

}
