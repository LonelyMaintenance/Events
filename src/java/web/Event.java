package web;

/*
Initierar objekt Event
 */
/**
 *
 * @author nikolaj
 */
public class Event {

    private String name;
    private String desc;

    public Event() {
    }

    public Event(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
