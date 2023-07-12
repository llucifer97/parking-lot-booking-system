package model;

import java.util.List;

public class ParkingLot {

    private String Id;
    private List<Floor> floorList;


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public List<Floor> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<Floor> floorList) {
        this.floorList = floorList;
    }
}
