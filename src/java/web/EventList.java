/*
Initierar Event objekt
 */
package web;

/**
 *
 * @author nikolaj
 */
public class EventList {

    String id;

    String eventName;
    String price;
    String availableSeats;
    String date;
    boolean isCancelled;

    public EventList(String v1, String v2, String v3, String v4, String v5, boolean v6) {
        id = v1;
        eventName = v2;
        price = v3;
        availableSeats = v4;
        date = v5;
        isCancelled = v6;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(String availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isIsCancelled() {
        return isCancelled;
    }

    public void setIsCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    
}
