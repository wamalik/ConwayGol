package com.conwaygol.model;

import static org.junit.Assert.*;

import org.junit.Test;


public class GridTest {
   
    @Test
    public void testGetNeighbours() {
        //Board b = new Board(3, 3, 0.0);
        
        Cell[][] cells = {
            {new Cell(true), new Cell(true), new Cell(true)}, 
            {new Cell(true), new Cell(true), new Cell(true)}, 
            {new Cell(true), new Cell(true), new Cell(true)}
        };
        Grid b = new Grid(cells);

        assertEquals(3, b.getNeighboursCount(0,0));
        assertEquals(8, b.getNeighboursCount(1,1));
        assertEquals(5, b.getNeighboursCount(1,0));
    }

    @Test
    public void testAllCellsDie() {
        Cell[][] cells = {
            {new Cell(true), new Cell(), new Cell(true)}, 
            {new Cell(), new Cell(), new Cell()}, 
            {new Cell(true), new Cell(), new Cell(true)}
        };

        Grid b = new Grid(cells);

        assertEquals(true, b.isCellAlive(0, 0));
        assertEquals(false, b.isCellAlive(1, 1));

        b.executeNextGeneration();

        assertEquals(false, b.isCellAlive(0, 0));
        assertEquals(false, b.isCellAlive(2, 2));
        assertEquals(false, b.isCellAlive(2, 0));
        assertEquals(false, b.isCellAlive(0, 2));
        assertEquals(false, b.isCellAlive(1, 1));
    }

    @Test
    public void testGridStaysTheSame() {
        Cell[][] cells = {
            {new Cell(true), new Cell(true), new Cell()}, 
            {new Cell(true), new Cell(true), new Cell()}, 
            {new Cell(), new Cell(), new Cell()}
        };

        Grid b = new Grid(cells);

        b.executeNextGeneration();

        assertSame(cells, b.getCells());
    }

    @Test
    public void testOverpopulationAndIsBorn() {
        Cell[][] cells = {
            {new Cell(true), new Cell(true), new Cell(true)}, 
            {new Cell(true), new Cell(true), new Cell()}, 
            {new Cell(), new Cell(), new Cell()}
        };   
        
        Grid b = new Grid(cells);
        
        b.executeNextGeneration();
        
        assertEquals(true, b.isCellAlive(0, 0));
        assertEquals(true, b.isCellAlive(0, 2));
        assertEquals(true, b.isCellAlive(1, 0));
        assertEquals(true, b.isCellAlive(1, 2));
        
        assertEquals(false, b.isCellAlive(0, 1));
        assertEquals(false, b.isCellAlive(1, 1));
    }
}
