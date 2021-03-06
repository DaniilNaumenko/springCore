package by.naumenka.service.impl;

import by.naumenka.dao.TicketDao;
import by.naumenka.exception.TicketNotFoundException;
import by.naumenka.model.Event;
import by.naumenka.model.Ticket;
import by.naumenka.model.User;
import by.naumenka.model.impl.TicketImpl;
import by.naumenka.service.TicketService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TicketServiceImpl implements TicketService {

    private static final Log LOGGER = LogFactory.getLog(TicketServiceImpl.class);
    private final TicketDao ticketDao;

    public TicketServiceImpl(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) throws TicketNotFoundException {
        Long maxId = ticketDao.getAllTickets().stream()
                .max(Comparator.comparing(Ticket::getId))
                .map(Ticket::getId)
                .orElseThrow(() -> new TicketNotFoundException("There are no tickets in storage"));
        Ticket ticket = new TicketImpl(eventId, userId, category, place);
        LOGGER.info("bookTicket" + ticket);
        ticket.setId(maxId + 1);
        ticketDao.createTicket(ticket);
        return ticketDao.readTicket(ticket.getId());
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        LOGGER.info("getBookedTickets by user " + user);
        return ticketDao.getAllTickets()
                .stream()
                .filter(ticket -> ticket.getUserId() == user.getId())
                .sorted(Comparator.comparing(Ticket::getId))
                .skip(((long) pageSize * pageNum) - pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        LOGGER.info("getBookedTickets by event " + event);
        return ticketDao.getAllTickets()
                .stream()
                .filter(ticket -> ticket.getEventId() == event.getId())
                .sorted(Comparator.comparing(Ticket::getId))
                .skip(((long) pageSize * pageNum) - pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        LOGGER.info("cancelTicket " + ticketId);
        Ticket ticket = ticketDao.deleteTicket(ticketId);
        return ticket != null;
    }
}