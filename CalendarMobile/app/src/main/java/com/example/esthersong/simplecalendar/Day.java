package com.example.esthersong.simplecalendar;

import java.util.ArrayList;

public class Day {
    private int day;
    private ArrayList<Event> allEvent = new ArrayList<>();

    public Day(int day){
        this.day = day;
    }

    public int getDay(){
        return day;
    }

    public void addEvent(Event e) {
        allEvent.add(e);
    }

    public ArrayList<Event> getAllEvent() {
        return allEvent;
    }

    public void setDay(int day){
        this.day = day;
    }
}
