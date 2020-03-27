package main.model.bc;

import main.model.Space;

public class PeriodicBoundaryCondition extends BoundaryCondition {
    public PeriodicBoundaryCondition(Space space) {
        super(space);
    }

    @Override
    public int getCorrectedStatus(int cellPosition) {
        if (cellPosition < 0) return space.getCell(space.getSize() - 1).getStatus();
        if (cellPosition >= space.getSize()) return space.getCell(0).getStatus();
        return space.getCell(cellPosition).getStatus();
    }
}
