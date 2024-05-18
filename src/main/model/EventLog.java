package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


// Represents a log of events occurring during runtime. We use the Singleton Design Pattern to ensure that there is
    // one EventLog in the system and that the system has global access to the single instance of the EventLog.
// Based on AlarmSystem from GitHub
public class EventLog implements Iterable<Event> {
    /** the only EventLog in the system (Singleton Design Pattern) */
    private static EventLog theLog;
    private Collection<Event> events;

    /**
     * Prevent external construction.
     * (Singleton Design Pattern).
     */
    // EFFECTS: creates an eventLog with an empty list of events
    private EventLog() {
        events = new ArrayList<>();
    }

    // EFFECTS: creates an instance of eventLog if the log does not exist yet and returns the eventLog
    public static EventLog getInstance() {
        if (theLog == null) {
            theLog = new EventLog();
        }
        return theLog;
    }

    // REQUIRES: an event object
    // EFFECTS: adds an event to the event log
    public void logEvent(Event e) {
        events.add(e);
    }

    // EFFECTS: clears the event log and logs the event
    public void clear() {
        events.clear();
        logEvent(new Event("Event log cleared."));
    }


    // EFFECTS: returns an iterator that iterates over the list of events
    @Override
    public Iterator<Event> iterator() {
        return events.iterator();
    }

    // EFFECTS: returns a string representation of the list of events
    @Override
    public String toString() {
        String message = "";
        for (Event e: events) {
            message += e.toString();
        }
        return message;
    }
}