package com.hostel.model;

public class Room {
    private int number;
    private boolean empty;

    public Room(int number) {
        this.number = number;
        this.empty = true; 
    }

    public boolean isEmpty() {
        return empty;
    }
    public void book() {
        empty = false;
    }
}