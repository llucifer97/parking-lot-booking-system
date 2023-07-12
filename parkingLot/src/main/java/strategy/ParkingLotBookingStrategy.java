package strategy;

import enums.VehicleType;
import model.ParkingSlot;

public interface ParkingLotBookingStrategy {

    ParkingSlot bookParkingSlot(VehicleType vehicleType);

}
