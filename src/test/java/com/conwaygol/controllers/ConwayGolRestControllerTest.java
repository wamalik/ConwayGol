package com.conwaygol.controllers;

import com.conwaygol.model.GridState;
import com.conwaygol.services.impl.GameOfLifeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class ConwayGolRestControllerTest {

    @InjectMocks
    ConwayGolRestController conwayGolRestController;

    @Mock
    GameOfLifeService gameOfLifeService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnGridStates_GivenValidNbrOfGenerations(){
        //given
        String nbrOfGenerations = "4";
        List<GridState> states = new ArrayList<>();
        states.add(new GridState(0,"v1"));
        states.add(new GridState(1,"v2"));
        states.add(new GridState(2,"v3"));
        states.add(new GridState(3,"v4"));
        //when
        when(gameOfLifeService.playGame(nbrOfGenerations)).thenReturn(states);
        List gridStates = conwayGolRestController.playGolGame(nbrOfGenerations);

        //then
        assertNotNull(gridStates);
        assertThat(gridStates.size(), greaterThan(0));
        assertEquals(gridStates, states);
    }



}