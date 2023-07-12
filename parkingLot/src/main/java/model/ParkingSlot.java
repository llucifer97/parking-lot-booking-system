package model;

import enums.SlotStatus;
import enums.VehicleType;

import java.util.List;

public class ParkingSlot {

    private int Id;
    private int floorId;
    private Vehicle vehicle;
    private VehicleType vehicleType;
    private SlotStatus slotStatus;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public SlotStatus getSlotStatus() {
        return slotStatus;
    }

    public void setSlotStatus(SlotStatus slotStatus) {
        this.slotStatus = slotStatus;
    }
}
