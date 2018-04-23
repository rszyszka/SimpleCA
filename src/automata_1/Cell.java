/*
 * Copyright (C) 2018 Szysz
 */
package automata_1;

/**
 *
 * @author Szysz
 */
public class Cell {

    private int status, left, right;
    private int rule;

    public Cell(int status, int left, int right, int rule) {
        this.status = status;
        this.left = left;
        this.right = right;
        this.rule = rule;
    }

    public void nextIteration() {

        if (left == 0 && status == 0 && right == 0) {
            status = getBit(rule, 0);
        } else if (left == 0 && status == 0 && right == 1) {
            status = getBit(rule, 1);
        } else if (left == 0 && status == 1 && right == 0) {
            status = getBit(rule, 2);
        } else if (left == 0 && status == 1 && right == 1) {
            status = getBit(rule, 3);
        } else if (left == 1 && status == 0 && right == 0) {
            status = getBit(rule, 4);
        } else if (left == 1 && status == 0 && right == 1) {
            status = getBit(rule, 5);
        } else if (left == 1 && status == 1 && right == 0) {
            status = getBit(rule, 6);
        } else if (left == 1 && status == 1 && right == 1) {
            status = getBit(rule, 7);
        }
    }

    public void view() {
        if (status == 1) {
            System.out.print("*");
        } else {
            System.out.print(" ");
        }
    }

    public void update(Cell prev, Cell next) {
        this.left = prev.status;
        this.right = next.status;
    }

    public int getBit(int n, int k) {
        return (n >> k) & 1;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int stan) {
        this.status = stan;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getRule() {
        return rule;
    }

    public void setRule(int rule) {
        this.rule = rule;
    }

}
