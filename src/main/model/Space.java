package main.model;

public class Space {
    private final int size;
    private Cell[] cells;

    public Space(int size) {
        this.size = size;
        cells = new Cell[size];
        for (int i = 0; i < size; i++) {
            cells[i] = new Cell();
        }
    }

    public Space(Space space) {
        this.size = space.getSize();
        cells = new Cell[size];
        for (int i = 0; i < size; i++) {
            cells[i] = new Cell();
            cells[i].setStatus(space.getCell(i).getStatus());
        }
    }

    public void copyCellsState(Space space) {
        for (int i = 0; i < size; i++) {
            getCell(i).setStatus(space.getCell(i).getStatus());
        }
    }

    public int getSize() {
        return size;
    }

    public Cell getCell(int i) {
        return cells[i];
    }

    public Cell[] getCells() {
        return cells;
    }
}
