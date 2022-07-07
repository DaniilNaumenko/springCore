package by.naumenka.service;

import by.naumenka.model.Event;

import java.util.Date;
import java.util.List;

public interface EventService {

    Event getById(long id);

    List<Event> getEventsByTitle(String title, int pageSize, int pageNum);

    List<Event> getEventsForDay(Date day, int pageSize, int pageNum);

    Event createEvent(Event event);

    Event updateEvent(Event event);

    boolean deleteEvent(long eventId);
}