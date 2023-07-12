package domain;

import DTO.ParkSlotDTO;
import DTO.ParkingLotDTO;
import enums.SlotStatus;
import enums.VehicleType;
import model.ParkingSlot;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingSlotDomain {

    List<ParkingSlot> parkingSlotList ;

    public ParkingSlotDomain() {
        parkingSlotList = new ArrayList<>();
    }


    public ParkingSlot createParkingSlot(ParkSlotDTO parkSlotDTO) {
        ParkingSlot parkingSlot = new ParkingSlot();
        parkingSlot.setFloorId(parkSlotDTO.getFloorId());
        parkingSlot.setSlotStatus(SlotStatus.AVAILABLE);
        parkingSlot.setVehicleType(parkSlotDTO.getVehicleType());

        if(!parkingSlotList.isEmpty()) {
            int idx = parkingSlotList.stream().sorted().filter(i -> i.getFloorId() == parkSlotDTO.getFloorId())
                    .collect(Collectors.toList()).get(0).getId() + 1;
            parkingSlot.setId(idx);
        }
        else {
            parkingSlot.setId(1);
        }

        return parkingSlot;
    }

    public List<ParkingSlot> createBulkParkingSlotForGivenFloor(int numOfSlot , int floorId) {

        ParkSlotDTO parkSlotDTO = new ParkSlotDTO();
        parkSlotDTO.setVehicleType(VehicleType.TRUCK);
        parkSlotDTO.setFloorId(floorId);

        createParkingSlot(parkSlotDTO);

        parkSlotDTO.setVehicleType(VehicleType.BIKE);

        for(int i = 0; i < 2 ; i++) {
            createParkingSlot(parkSlotDTO);
        }

        for(int i = 0; i < numOfSlot - 3 ; i++) {
            parkSlotDTO.setVehicleType(VehicleType.CAR);
            createParkingSlot(parkSlotDTO);
        }

        return parkingSlotList.stream()
                .filter(i -> i.getFloorId() == floorId).collect(Collectors.toList());
    }

    public List<ParkingSlot> fetchParkingSlots() {
        return parkingSlotList;
    }

    public ParkingSlot findById(int id , int floorId) {
        return parkingSlotList.stream()
                .filter(i -> i.getId() == id && i.getFloorId() == floorId)
                .collect(Collectors.toList()).get(0);
    }

    public void update(ParkingSlot parkingSlot) {
        ParkingSlot parkingSlot1 = parkingSlotList.stream()
                .filter(i -> i.getId() == parkingSlot.getId() && i.getFloorId() == parkingSlot.getFloorId())
                .collect(Collectors.toList()).get(0);

        parkingSlotList.remove(parkingSlot1);
        parkingSlotList.add(parkingSlot);
    }

}
