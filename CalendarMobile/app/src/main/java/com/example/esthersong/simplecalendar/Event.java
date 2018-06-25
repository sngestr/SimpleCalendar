package com.example.esthersong.simplecalendar;

public class Event {
    private int day;
    private int month;
    private int year;
    private String description;
    private String title;
    private String startTime;
    private String endTime;

    public Event (int day, int month, int year, String description, String title, String startTime, String endTime){
        this.day = day;
        this.month = month;
        this.year = year;
        this.description = description;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public String getDescription() {
        return description;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getTitle() {
        return title;
    }
}