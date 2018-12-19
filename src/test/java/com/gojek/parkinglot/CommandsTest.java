package com.gojek.parkinglot;

import org.junit.Test;
import static org.junit.Assert.*;

public class InputTest {
    Input input = new Input();
    @Test
    public void checkInputInList() throws Exception {
        assertFalse(input.inputMap.isEmpty());
        assertTrue(input.inputMap.containsKey("create_parking_lot"));
        assertFalse(input.inputMap.containsKey("mytestcommand"));
    }
}