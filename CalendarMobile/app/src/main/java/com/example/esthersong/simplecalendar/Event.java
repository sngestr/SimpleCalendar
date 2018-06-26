package com.example.esthersong.simplecalendar;

public class Event {
    private int eventId;
    private int day;
    private int month;
    private int year;
    private String description;
    private String title;
    private String startTime;
    private String endTime;

    public Event (int eventId, int day, int month, int year, String description, String title, String startTime, String endTime){
        this.eventId = eventId;
        this.day = day;
        this.month = month;
        this.year = year;
        this.description = description;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getEventId(){
        return eventId;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setStartTime(String startTime){
        this.startTime = startTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}