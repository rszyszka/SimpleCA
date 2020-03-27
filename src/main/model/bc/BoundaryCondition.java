package main.model.bc;

import main.model.Space;

public abstract class BoundaryCondition {

    protected Space space;

    public BoundaryCondition(Space space) {
        this.space = space;
    }

    public static BoundaryCondition getInstance(Type type, Space space) {
        if (type == Type.PERIODIC) {
            return new PeriodicBoundaryCondition(space);
        } else {
            return new ClosedBoundaryCondition(space);
        }
    }

    public abstract int getCorrectedStatus(int cellPosition);


    public enum Type {
        PERIODIC("Periodyczny"),
        CLOSED("Zamknięty");

        private String description;

        Type(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }
    }
}
