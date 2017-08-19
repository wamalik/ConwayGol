package com.conwaygol.services.impl;



import com.conwaygol.model.GridState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GameOfLifeService {
	
	
	@Autowired
	GenerationExecutionService generationExecutionService;

	@Autowired
	RenderingService renderingService;

	public List<GridState> playGame(String numOfGenerations) {
		List<GridState> states = new ArrayList<>();
		try {
			 states = generationExecutionService.executeGenerations(Integer.parseInt(numOfGenerations));
		}catch (Exception e){
			// to do
		}
		return states;
	}

}
