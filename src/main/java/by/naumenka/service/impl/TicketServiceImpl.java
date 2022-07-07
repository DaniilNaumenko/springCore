package by.naumenka.service.impl;

import by.naumenka.dao.TicketDao;
import by.naumenka.model.Event;
import by.naumenka.model.Ticket;
import by.naumenka.model.User;
import by.naumenka.service.TicketService;

import java.util.List;

public class TicketServiceImpl implements TicketService {

    private final TicketDao ticketDao;

    public TicketServiceImpl(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        return null;
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return false;
    }
}