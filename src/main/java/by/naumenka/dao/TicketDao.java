package by.naumenka.dao;

import by.naumenka.model.Ticket;

import java.util.List;

public interface TicketDao {

    Ticket createTicket(Ticket ticket);

    Ticket readTicket(long id);

    Ticket updateTicket(Ticket ticket);

    Ticket deleteTicket(long id);

    List<Ticket> getAllTickets();
}