/*
Hanterar hämtning av lista över alla event som finns registrerade i db, via AdminEventBean.
Denna bean är till för att processa användarens val.
 */
package bean;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.faces.event.ActionEvent;
import web.Event;
import web.EventList;

@ManagedBean(name = "bean")
@SessionScoped
public class EventsBean implements Serializable {

    private List<EventList> data; 
    private String event; 
    private String msg; 
    EventList e;
    ArrayList<EventList> eventList;
    String chosen;

    public EventsBean() throws SQLException {

        this.eventList = getEventList();
        loadData();
        // initierar med att peka på första objekt i listan
        this.e = data.get(0);
        setEvent(e.getEventName());
        setMessage(e.getEventName() + " selected.");
    }

    private void loadData() {


        data = new ArrayList<>();

        for (int i = 0; i < eventList.size(); i++) {
 
            data.add(eventList.get(i));
        }
        
    }

    public List<EventList> getData() {
        return data;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String t) {
        this.event = t;
    }

    public void valueChanged(ValueChangeEvent v) {
        this.chosen = (String) v.getNewValue();
        setMessage(chosen + " selected.");
    }

    public void saveListener(ActionEvent a) {
        setMessage(chosen + " added to cache.");

    }

    public void setMessage(String s) {
        msg = s;
    }

    public String getMessage() {
        return msg;
    }

    //Hämtar lista över alla användare från db via AdminEventBean
    public ArrayList<EventList> getEventList() throws SQLException {
        AdminEventBean adb = new AdminEventBean(); 
        adb.init();
        ArrayList<EventList> eventList = adb.getEventsStatement();
        for (int i = 0; i < eventList.size(); i++) {
            System.out.println(eventList.get(i));
        }
        adb.closeConnection();
        this.chosen = eventList.get(0).getEventName();
        return eventList;

    }
}
