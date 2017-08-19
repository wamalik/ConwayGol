package com.conwaygol.model;

public class Cell {
    private boolean currentState = false;
    private boolean newState;

    public Cell() {

    }

    public Cell(boolean state) {
        this.currentState = state;
    }

    public void setNewState(boolean state) {
        newState = state;
    }

    public void updateState() {
        currentState = newState;
    }

    public boolean getCurrentState() {
        return currentState;
    }
}
