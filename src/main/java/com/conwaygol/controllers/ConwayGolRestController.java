package com.conwaygol.controllers;

import com.conwaygol.model.GridState;
import com.conwaygol.services.impl.GameOfLifeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ConwayGolRestController {

    @Autowired
    GameOfLifeService gameOfLifeService;

    @RequestMapping(value = {"/start","/conwaygol/start"}, method = RequestMethod.GET)
    public ModelAndView dashboard() {
        ModelAndView model = new ModelAndView();
        model.setViewName("gameoflife");
        return model;
    }

    @RequestMapping(value = {"/play/{generations}","/conwaygol/play/{generations}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<GridState> playGolGame(@PathVariable("generations") String numOfGenerations) {
            return gameOfLifeService.playGame(numOfGenerations);
    }

}
