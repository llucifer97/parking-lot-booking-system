package DTO;


import model.Floor;

import java.util.List;

public class ParkingLotDTO {

    private String parkingLotId;
    private int numOfFloors;
    private int numOfSlotsPerFloor;
    private List<Floor> floorList;

    public ParkingLotDTO(String parkingLotId, int numOfFloors, int numOfSlotsPerFloor) {
        this.parkingLotId = parkingLotId;
        this.numOfFloors = numOfFloors;
        this.numOfSlotsPerFloor = numOfSlotsPerFloor;
    }

    public List<Floor> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<Floor> floorList) {
        this.floorList = floorList;
    }



    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public int getNumOfFloors() {
        return numOfFloors;
    }

    public void setNumOfFloors(int numOfFloors) {
        this.numOfFloors = numOfFloors;
    }

    public int getNumOfSlotsPerFloor() {
        return numOfSlotsPerFloor;
    }

    public void setNumOfSlotsPerFloor(int numOfSlotsPerFloor) {
        this.numOfSlotsPerFloor = numOfSlotsPerFloor;
    }
}
