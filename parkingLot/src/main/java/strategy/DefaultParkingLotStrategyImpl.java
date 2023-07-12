package strategy;

import domain.ParkingSlotDomain;
import enums.SlotStatus;
import enums.VehicleType;
import model.ParkingSlot;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultParkingLotStrategyImpl implements ParkingLotBookingStrategy {


    private final ParkingSlotDomain parkingSlotDomain;

    public DefaultParkingLotStrategyImpl() {
        this.parkingSlotDomain = new ParkingSlotDomain();
    }

    @Override
    public ParkingSlot bookParkingSlot(VehicleType vehicleType) {

        /*
        The slot should be of the same type as the vehicle.
        The slot should be on the lowest possible floor in the parking lot.
        The slot should have the lowest possible slot number on the floor.
         */
        List<ParkingSlot> parkingSlotList = parkingSlotDomain.fetchParkingSlots().stream()
                .filter(i -> i.getVehicleType().equals(vehicleType) )
                .filter(i -> i.getSlotStatus().equals(SlotStatus.AVAILABLE))
                .sorted()
                .collect(Collectors.toList());

        if(parkingSlotList.isEmpty()) {
            System.out.println("nothing to book bruh");
            return null;
        }



        return parkingSlotList.get(0);


    }
}
