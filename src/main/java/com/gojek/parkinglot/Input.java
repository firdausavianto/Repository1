package com.gojek.parkinglot;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.HashMap;

public class Input {
    public Map<String, Method> inputMap;

    public Input() {
        inputMap = new HashMap<String, Method>();

        try {
            populateInputHashMap();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    private void populateInputHashMap() throws NoSuchMethodException {
        inputMap.put("create_parking_lot", ParkingLot.class.getMethod("createParkingLot", String.class));
        inputMap.put("park", ParkingLot.class.getMethod("park", String.class, String.class));
        inputMap.put("leave", ParkingLot.class.getMethod("leave", String.class));
        inputMap.put("status", ParkingLot.class.getMethod("status"));
        inputMap.put("registration_numbers_for_cars_with_colour", ParkingLot.class.getMethod("getRegistrationNumbersFromColor", String.class));
        inputMap.put("slot_numbers_for_cars_with_colour", ParkingLot.class.getMethod("getSlotNumbersFromColor", String.class));
        inputMap.put("slot_number_for_registration_number", ParkingLot.class.getMethod("getSlotNumberFromRegistrationNumber", String.class));
    }

}
