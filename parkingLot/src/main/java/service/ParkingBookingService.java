package service;

import DTO.TicketDTO;
import domain.ParkingSlotDomain;
import domain.TicketDomain;
import enums.SlotStatus;
import enums.VehicleType;
import model.ParkingSlot;
import model.Ticket;
import strategy.ParkingLotBookingFactory;
import strategy.ParkingLotBookingStrategy;

import java.util.Arrays;
import java.util.List;

public class ParkingBookingService {


    private final ParkingLotBookingFactory parkingLotBookingFactory;
    private final TicketDomain ticketDomain;
    private final ParkingSlotDomain parkingSlotDomain;

    public ParkingBookingService() {
        this.ticketDomain = new TicketDomain();
        this.parkingLotBookingFactory = new ParkingLotBookingFactory();
        this.parkingSlotDomain = new ParkingSlotDomain();
    }


    public ParkingSlot bookParkingLot(VehicleType vehicleType , String carNumber , String color ) {

        // find slot & book the slot
        ParkingLotBookingStrategy parkingLotBookingStrategy = parkingLotBookingFactory.from("default");

        ParkingSlot parkingSlot = parkingLotBookingStrategy.bookParkingSlot(vehicleType);
        if(parkingSlot != null) {
            parkingSlot.setSlotStatus(SlotStatus.BOOKED);

            ticketDomain.createTicket( new TicketDTO( "PR1234", parkingSlot.getId(),parkingSlot.getFloorId()));
        }


        return parkingSlot;
    }

    public void unParkLot(String ticketId) {

        List<String> details = Arrays.asList(ticketId.split("_"));
        int slotId = Integer.parseInt(details.get(2));
        int floorId = Integer.parseInt(details.get(1));
        ParkingSlot parkingSlot = parkingSlotDomain.findById(slotId,floorId);
        parkingSlot.setSlotStatus(SlotStatus.AVAILABLE);
        parkingSlot.setVehicleType(null);
        parkingSlotDomain.update(parkingSlot);

    }
}
