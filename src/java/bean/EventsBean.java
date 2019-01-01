/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
@ManagedBean(name="bean")
@SessionScoped
public class EventsBean implements Serializable {
	private List<EventList> data; // todo list data
	private String event; // the currently selected item value
	private String msg; // status message
        EventList e;
        ArrayList<EventList> eventList;
        String chosen;
                
	public EventsBean() throws SQLException {
            
            this.eventList = getEventList();
		loadData();
		// select the first item in the list
		this.e = data.get(0);
		setEvent(e.getEventName());
		setMessage(e.getEventName() + " selected.");
	}
	private void loadData() {
            /*
            data = new ArrayList<>();
            ArrayList<String> eventList = getEventList();
            for(int i = 0; i < eventList.size(); i++){
                Event e = new Event(eventList.get(i), String.format("%s description", eventList.get(i)));
                data.add(e);
            }*/
            
            
		data = new ArrayList<>();
                
                for(int i = 0; i < eventList.size(); i++){
                //    Event e = new Event(eventList.get(i).getEventName(), String.format("%s description", eventList.get(i)));
                    data.add(eventList.get(i));    
                }
             /*   
                data = new ArrayList<>();
           	Event e = new Event("item 1", "item 1 description");
		data.add(e);
		e = new Event("item 2", "item 2 description");
		data.add(e);
		e = new Event("item 3", "item 3 description");
		data.add(e);
		e = new Event("item 4", "item 4 description");
		data.add(e);
               */ 
           //            AdminEventBean adb = new AdminEventBean(); //(TeacherInforRemRemote) Naming.lookup ("ava:global/CourseEJB/beans/TeacherInfoRem");

            
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
	// value change listener for list item selection
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
        public ArrayList<EventList> getEventList() throws SQLException{
        AdminEventBean adb = new AdminEventBean(); //(TeacherInforRemRemote) Naming.lookup ("ava:global/CourseEJB/beans/TeacherInfoRem");
        adb.init();  
        ArrayList<EventList> eventList = adb.getEventsStatement();
        for(int i = 0; i < eventList.size(); i++){
            System.out.println(eventList.get(i));
        }
        adb.closeConnection();
        this.chosen = eventList.get(0).getEventName();
       return eventList;
       
   }
}