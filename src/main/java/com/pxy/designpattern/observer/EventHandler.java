package com.pxy.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class EventHandler {
    private static List<Event> events = new ArrayList<>();
    public static void addEvent(Event event) {
        events.add(event);
    }
    public static void removeEvent(Event event) {
        events.remove(event);
    }
    public static void Notify(int price) {
        for (Event event:events) {
            event.Notify(price);
        }
    }
}
