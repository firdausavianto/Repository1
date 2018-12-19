package com.gojek.parkinglot;

import java.util.*;

public class ParkingLot {
    int maxLot = 0;
    
	private class car {
        String registrationNumber, color;

        public car(String registrationNumber, String color) {
            this.registrationNumber = registrationNumber;
            this.color = color;
        }
    }
	
    ArrayList<Integer> availableSlotList;
    Map<String, car> map1;
    Map<String, String> map2;
    Map<String, ArrayList<String>> map3;

    public void createParkingLot(String numberOfLot) {
		int i;
        try {
            this.maxLot += Integer.parseInt(numberOfLot);
        } catch (Exception e) {
            System.out.println("Please enter a number.");
        }
        this.availableSlotList = new ArrayList<Integer>() {};
        for (i=1; i<=this.maxLot; i++) {
            availableSlotList.add(i);
        }
        this.map1 = new HashMap<String, car>();
        this.map2 = new HashMap<String, String>();
        this.map3 = new HashMap<String, ArrayList<String>>();
		
        System.out.println(numberOfLot + " parking lot created");
        System.out.println();
    }
	
    public void park(String registrationNumber, String color) {
        if (this.maxLot == 0) {
            System.out.println("Please create parking lot first");
            System.out.println();
        } else if (this.map1.size() == this.maxLot) {
            System.out.println("Parking lot is full");
            System.out.println();
        } else {
            Collections.sort(availableSlotList);
            String slot = availableSlotList.get(0).toString();
            car parkingCar = new car(registrationNumber, color);
            this.map1.put(slot, parkingCar);
            this.map2.put(registrationNumber, slot);
            if (this.map3.containsKey(color)) {
                ArrayList<String> registrationNumberList = this.map3.get(color);
                this.map3.remove(color);
                registrationNumberList.add(registrationNumber);
                this.map3.put(color, registrationNumberList);
            } else {
                ArrayList<String> registrationNumberList = new ArrayList<String>();
                registrationNumberList.add(registrationNumber);
                this.map3.put(color, registrationNumberList);
            }
            System.out.println("Allocated slot number: " + slot);
            System.out.println();
            availableSlotList.remove(0);
        }
    }
    public void leave(String slotNo) {
        if (this.maxLot == 0) {
            System.out.println("Please create parking lot first");
            System.out.println();
        } else if (this.map1.size() > 0) {
            car leaveCar = this.map1.get(slotNo);
            if (leaveCar != null) {
                this.map1.remove(slotNo);
                this.map2.remove(leaveCar.registrationNumber);
                ArrayList<String> registrationNumberList = this.map3.get(leaveCar.color);
                if (registrationNumberList.contains(leaveCar.registrationNumber)) {
                    registrationNumberList.remove(leaveCar.registrationNumber);
                }
                
                this.availableSlotList.add(Integer.parseInt(slotNo));
                System.out.println("Slot number " + slotNo + " is free");
                System.out.println();
            } else {
                System.out.println("Slot number " + slotNo + " is already empty");
                System.out.println();
            }
        } else {
            System.out.println("Parking lot is empty");
            System.out.println();
        }
    }
    public void status() {
		int i;
        if (this.maxLot == 0) {
            System.out.println("Please create parking lot first");
            System.out.println();
        } else if (this.map1.size() > 0) {
            // Print the current status.
            System.out.println("Slot No.\tRegistration Number\tColor");
            car car;
            for (i=1; i<=this.maxLot; i++) {
                String key = Integer.toString(i);
                if (this.map1.containsKey(key)) {
                    car = this.map1.get(key);
                    System.out.println(i + "\t" + car.registrationNumber + "\t" + car.color);
                }
            }
            System.out.println();
        } else {
            System.out.println("Parking lot is empty");
            System.out.println();
        }
    }
    public void getRegistrationNumbersFromColor(String color) {
        if (this.maxLot == 0) {
            System.out.println("Please create parking lot first");
            System.out.println();
        } else if (this.map3.containsKey(color)) {
            ArrayList<String> registrationNumberList = this.map3.get(color);
            System.out.println();
            for (int i=0; i < registrationNumberList.size(); i++) {
                if (!(i==registrationNumberList.size() - 1)){
                    System.out.print(registrationNumberList.get(i) + ",");
                } else {
                    System.out.print(registrationNumberList.get(i));
                }
            }
        } else {
            System.out.println("Not found");
            System.out.println();
        }
    }
    public void getSlotNumbersFromColor(String color) {
        if (this.maxLot == 0) {
            System.out.println("Please create parking lot first");
            System.out.println();
        } else if (this.map3.containsKey(color)) {
            ArrayList<String> registrationNumberList = this.map3.get(color);
            ArrayList<Integer> slotList = new ArrayList<Integer>();
            System.out.println();
            for (int i=0; i < registrationNumberList.size(); i++) {
                slotList.add(Integer.valueOf(this.map2.get(registrationNumberList.get(i))));
            }
            Collections.sort(slotList);
            for (int j=0; j < slotList.size(); j++) {
                if (!(j == slotList.size() - 1)) {
                    System.out.print(slotList.get(j) + ",");
                } else {
                    System.out.print(slotList.get(j));
                }
            }
            System.out.println();
        } else {
            System.out.println("Not found");
            System.out.println();
        }
    }
    public void getSlotNumberFromRegistrationNumber(String registrationNumber) {
        if (this.maxLot == 0) {
            System.out.println("Please create parking lot first");
            System.out.println();
        } else if (this.map2.containsKey(registrationNumber)) {
            System.out.println(this.map2.get(registrationNumber));
        } else {
            System.out.println("Not found");
            System.out.println();
        }
    }
}
