package com.conwaygol.model;

public class Grid {
    private Cell[][] cells;
    private int height=3; 
    private int width=3;

    public Grid(Cell[][] cells) {
        this.cells = cells;
        height = width = cells.length;
    }


    public Grid(int height, int width, double p) {
        this.height=height;
        this.width = width;
        cells = new Cell[height][width];
        
        for (int h=0; h<cells.length; h++){
            for (int w=0; w<cells[h].length; w++){
                cells[h][w] = new Cell();
                if (Math.random()<=p){
                    cells[h][w].setNewState(true);
                    cells[h][w].updateState();
                }
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }
    
    public int getSize() {
        return width;
    }

    public int getNeighboursCount(int row, int col) {
        int sum=0;
        if (row != 0 && col != 0){
            if(isCellAlive(row-1,col-1)){
                sum++;
            }
        }
        
        if (row != 0){
            if(isCellAlive(row-1,col)){
            sum++;
            }
        }
        
        if (row != 0 && col != width-1){
            if(isCellAlive(row-1,col+1)){
                sum++;
            }
        }
        if (col != 0){
            if(isCellAlive(row,col-1)){
            sum++;
            }
        }

        if (col != width-1){
            if(isCellAlive(row,col+1)){
                sum++;
            }
        }

        if (row != height-1 && col != 0){
            if(isCellAlive(row+1,col-1)){
                sum++;
            }
        }

        if (row != height-1){
            if(isCellAlive(row+1,col)){
            sum++;
            }
        }

        if (row != height-1 && col != width-1){
            if(isCellAlive(row+1,col+1)){
                sum++;
            }
        }

        return sum;
    }

    public boolean isCellAlive(int row, int col) {
        return cells[row][col].getCurrentState();
    }

    public void executeNextGeneration() {
        processGolRules();
        updateCellState();
    }

    private void processGolRules() {
        for (int h=0; h<cells.length; h++){
            for (int w=0; w<cells[h].length; w++){
                int neighbours = getNeighboursCount(h,w);

                //under-populated
                if (neighbours < 2) {
                    cells[h][w].setNewState(false);
                }
                //over-crowded
                else if (neighbours > 3) {
                    cells[h][w].setNewState(false);
                } //born/re-born
                else if (neighbours == 3) {
                    cells[h][w].setNewState(true);
                }
                // stay alive
                else if (neighbours == 2) {
                    cells[h][w].setNewState(cells[h][w].getCurrentState());}
            }
        }
    }


    private void updateCellState() {
        for (int h=0; h<cells.length; h++){
            for (int w=0; w<cells[h].length; w++){
                cells[h][w].updateState();
            }
        }
    }
    
    
}
