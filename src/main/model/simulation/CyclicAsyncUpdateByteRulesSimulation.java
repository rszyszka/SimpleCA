package main.model.simulation;

import main.model.Space;
import main.model.bc.BoundaryCondition;

import java.util.Collections;


public class CyclicAsyncUpdateByteRulesSimulation extends OrderedAsyncUpdateByteRulesSimulation {

    public CyclicAsyncUpdateByteRulesSimulation(int rule, Space space, BoundaryCondition bc) {
        super(rule, space, bc);
        Collections.shuffle(cellNumbers);
    }

}
