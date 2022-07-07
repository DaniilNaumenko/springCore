package by.naumenka.dao;

import by.naumenka.model.Event;
import by.naumenka.model.Ticket;

public interface TicketDao {

    Ticket createTicket(Ticket ticket);

    Ticket readTicket(long id);

    Ticket updateTicket(Ticket ticket);

    Ticket deleteTicket(long id);
}