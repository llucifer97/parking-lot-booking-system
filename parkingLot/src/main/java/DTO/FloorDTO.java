package DTO;

import model.ParkingSlot;

import java.util.List;

public class FloorDTO {

    private List<ParkingSlot> parkingSlotList;

    public List<ParkingSlot> getParkingSlotList() {
        return parkingSlotList;
    }

    public void setParkingSlotList(List<ParkingSlot> parkingSlotList) {
        this.parkingSlotList = parkingSlotList;
    }
}
