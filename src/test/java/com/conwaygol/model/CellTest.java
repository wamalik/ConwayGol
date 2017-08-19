package com.conwaygol.model;


import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class CellTest {

    @Test
    public void shouldUpdateState() {
        Cell c = new Cell();
        c.setNewState(true);
        c.updateState();
        assertEquals(true, c.getCurrentState());
    }

   

}
