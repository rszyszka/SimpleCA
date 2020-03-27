package main.model.simulation;

import main.model.Space;
import main.model.bc.BoundaryCondition;

import java.util.Collections;


public class RandomOrderedAsyncUpdateByteRulesSimulation extends OrderedAsyncUpdateByteRulesSimulation {

    public RandomOrderedAsyncUpdateByteRulesSimulation(int rule, Space space, BoundaryCondition bc) {
        super(rule, space, bc);
    }

    @Override
    public void nextIteration() {
        Collections.shuffle(cellNumbers);
        super.nextIteration();
    }
}
