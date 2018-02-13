package com.example.android.riviera.Models;

/**
 * Created by Dell on 06-02-2018.
 */

public class ModelClass {

    public String event_coordinator;
    public String club_name;
    public String event_name;
    public String time;

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String venue;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEvent_coordinator() {
        return event_coordinator;
    }

    public void setEvent_coordinator(String event_coordinator) {
        this.event_coordinator = event_coordinator;
    }

    public String getClub_name() {
        return club_name;
    }

    public void setClub_name(String club_name) {
        this.club_name = club_name;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }
}
