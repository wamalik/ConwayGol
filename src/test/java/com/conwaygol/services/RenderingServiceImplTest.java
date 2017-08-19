package com.conwaygol.services;

import com.conwaygol.services.impl.RenderingService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.conwaygol.model.Grid;
import com.conwaygol.model.GridState;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;


import static org.mockito.MockitoAnnotations.initMocks;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.CoreMatchers.equalTo;


public class RenderingServiceImplTest {


    @InjectMocks
    RenderingService displayService;

    @Before
    public void setUp() {
        initMocks(this);

    }

    @After
    public void tearDown() {

        displayService = null;
    }


    @Test
    public void shouldReturnInValidStateGivenInvalidGridAndStateNum() {
        //given
        int stateNum = 0;
        Grid newGrid = null;

        //when
        GridState state = displayService.renderGridState(newGrid, stateNum);

        //then
        assertThat(state, is(nullValue()));
    }

    @Test
    public void shouldReturnValidStateGivenValidGridAndStateNum() {
        //given
        int stateNum = 1;
        Grid newGrid = new Grid(10, 10, 0.3);

        //when
        GridState state = displayService.renderGridState(newGrid, stateNum);

        //then
        assertThat(state.getView(), is(notNullValue()));
        assertThat(state.getNum(), equalTo(stateNum));
    }


}
