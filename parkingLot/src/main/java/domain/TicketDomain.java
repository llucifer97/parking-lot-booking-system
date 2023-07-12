package domain;

import DTO.TicketDTO;
import model.Ticket;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class TicketDomain {

    private  List<Ticket> ticketList;

    public TicketDomain() {
        ticketList = new ArrayList<>();
    }


    public Ticket createTicket(TicketDTO ticketDTO) {
        Ticket ticket = new Ticket();
        ticket.setFloorId(String.valueOf(ticketDTO.getFloorId()));
        ticket.setId(ticketDTO.getParkingLotId() + "_" + ticketDTO.getFloorId() +"_" + ticketDTO.getSlotId() );
        ticket.setSlotId(String.valueOf(ticketDTO.getSlotId()));
        ticketList.add(ticket);
        return ticket;
    }


}
