package domain;

import DTO.ParkingLotDTO;
import model.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotDomain {


    List<ParkingLot> parkingLotList ;

    public ParkingLotDomain() {
        this.parkingLotList = new ArrayList<>();
    }


    public ParkingLot createParkingLot(ParkingLotDTO parkingLotDTO) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(parkingLotDTO.getParkingLotId());
        parkingLot.setFloorList(parkingLotDTO.getFloorList());
        return parkingLot;
    }




}
