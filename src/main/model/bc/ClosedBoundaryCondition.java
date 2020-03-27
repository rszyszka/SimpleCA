package main.model.bc;

import main.model.Space;

public class ClosedBoundaryCondition extends BoundaryCondition {
    public ClosedBoundaryCondition(Space space) {
        super(space);
    }

    @Override
    public int getCorrectedStatus(int cellPosition) {
        return cellPosition < 0 || cellPosition >= space.getSize() ? 0 : space.getCell(cellPosition).getStatus();
    }
}
