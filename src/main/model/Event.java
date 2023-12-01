package model;

import java.util.Calendar;
import java.util.Date;


// Represents an event occurring during the game
// Based on AlarmSystem from GitHub
public class Event {
    private static final int HASH_CONSTANT = 13;
    private Date dateLogged;
    private String description;

    // REQUIRES: a string describing the event
    // EFFECTS: creates an event with the given description and the current date/time stamp.
    public Event(String description) {
        dateLogged = Calendar.getInstance().getTime();
        this.description = description;
    }

    public Date getDate() {
        return dateLogged;
    }

    public String getDescription() {
        return description;
    }

    // REQUIRES: other != null
    // EFFECTS: compares two events, this and other, and returns true if they are equal
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        Event otherEvent = (Event) other;

        return (this.dateLogged.equals(otherEvent.dateLogged)
                &&
                this.description.equals(otherEvent.description));
    }

    // EFFECTS: returns a hash code from the hash codes of dateLogged and description
    @Override
    public int hashCode() {
        return (HASH_CONSTANT * dateLogged.hashCode() + description.hashCode());
    }

    // EFFECTS: returns a string representation of dateLogged
    @Override
    public String toString() {
        return dateLogged.toString() + "\n" + description;
    }
}