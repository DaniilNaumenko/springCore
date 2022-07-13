package by.naumenka.dao.impl;

import by.naumenka.dao.EventDao;
import by.naumenka.model.Event;
import by.naumenka.storage.Storage;

import java.util.ArrayList;
import java.util.List;

public class EventDaoImpl implements EventDao {

    private Storage storage;

    @Override
    public Event createEvent(Event event) {
        return storage.getEvents().put(event.getId(), event);
    }

    @Override
    public Event readEvent(long id) {
        return storage.getEvents().get(id);
    }

    @Override
    public Event updateEvent(Event event) {
        return storage.getEvents().replace(event.getId(), event);
    }

    @Override
    public Event deleteEvent(long id) {
        return storage.getEvents().remove(id);
    }

    @Override
    public List<Event> getAllEvents() {
        return new ArrayList<>(storage.getEvents().values());
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}