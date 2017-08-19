package com.conwaygol.services.impl;


import com.conwaygol.model.Cell;
import com.conwaygol.model.Grid;
import com.conwaygol.model.GridState;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RenderingService {

    public static final String DEAD = "dead_cell";
    public static final String ALIVE = "alive_cell";
    public static final String BREAK = "br";

    public GridState renderGridState(Grid grid, int num) {
        GridState state = null;
        if (grid != null) {
            state = new GridState();
            state.setNum(num);
            StringBuilder currentView = new StringBuilder();
            Cell[][] cells = grid.getCells();
            StringBuilder border = new StringBuilder();
            currentView.append(border.toString() + BREAK);
            Arrays.stream(cells).forEach(row -> {
                String r = "";
                for (Cell c : row) {
                    r += c.getCurrentState() ? DEAD + ALIVE : ALIVE + ALIVE;
                }
                r += "";
                currentView.append(r + BREAK);
            });

            currentView.append(border + BREAK);
            state.setView(currentView.toString());
        }
        return state;

    }


}
