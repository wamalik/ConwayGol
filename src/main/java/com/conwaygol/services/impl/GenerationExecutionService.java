package com.conwaygol.services.impl;


import com.conwaygol.model.Grid;
import com.conwaygol.model.GridState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class GenerationExecutionService {

    @Autowired
    RenderingService renderingService;

      public List<GridState> executeGenerations(int nbrOfGens) {
        List<GridState> gridStates = new ArrayList<GridState>();

        try {
            Grid grid = new Grid(10, 10, 0.3);

            // add default state
            GridState defaultState = renderingService.renderGridState(grid, 0);
            gridStates.add(defaultState);

            //execute generations
            IntStream.range(1, nbrOfGens+1).forEach(i -> {
                grid.executeNextGeneration();
                GridState state = renderingService.renderGridState(grid, i);
                gridStates.add(state);
            });


        } catch (Exception e) {
            // to do
        }

        return gridStates;
    }
}
