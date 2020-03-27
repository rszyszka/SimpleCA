package main.model.simulation;

public enum SimulationUpdateSchema {
    SYNCHRONOUS("Synchroniczny"),
    ORDERED_ASYNC("Uporządkowany - Asynchroniczny"),
    CYCLIC_ASYNC("Cykliczny - Asynchroniczny"),
    RANDOM_ORDERED_ASYNC("Losowy - Asynchroniczny");

    private String description;

    SimulationUpdateSchema(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}