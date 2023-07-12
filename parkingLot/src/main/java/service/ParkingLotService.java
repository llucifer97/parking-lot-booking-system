package service;

import DTO.FloorDTO;
import DTO.ParkingLotDTO;
import domain.FloorDomain;
import domain.ParkingLotDomain;
import domain.ParkingSlotDomain;
import enums.SlotStatus;
import enums.VehicleType;
import model.Floor;
import model.ParkingLot;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class ParkingLotService {


    private final ParkingLotDomain parkingLotDomain;
    private final FloorDomain floorDomain;
    private final ParkingSlotDomain parkingSlotDomain;


    public ParkingLotService() {
        this.parkingLotDomain = new ParkingLotDomain();
        this.floorDomain = new FloorDomain();
        this.parkingSlotDomain = new ParkingSlotDomain();

    }


    public ParkingLot createParkingLot(ParkingLotDTO parkingLotDTO) {

        for(int i = 0; i < parkingLotDTO.getNumOfFloors() ; i++) {
            floorDomain.createFloor(new FloorDTO());
        }

        List<Floor> floorList = floorDomain.fetchFloorList();

        floorList.forEach(i -> parkingSlotDomain.createBulkParkingSlotForGivenFloor(parkingLotDTO.getNumOfSlotsPerFloor(),i.getFloorId()));

        parkingLotDTO.setFloorList(floorList);

        return parkingLotDomain.createParkingLot(parkingLotDTO);
    }

    public void display(String displayType , VehicleType vehicleType) {

        switch (displayType) {

            case "free_count" :
                freeCountDisplay(vehicleType);
            case "free_slots" :
                freeSlotsDisplay(vehicleType,SlotStatus.AVAILABLE);
            case "occupied_slots" :
                freeSlotsDisplay(vehicleType,SlotStatus.BOOKED);

        }

    }

    private void freeCountDisplay(VehicleType vehicleType) {
        Map<Integer , Integer> vehicleTypeIntegerMap = new HashMap<>();

        parkingSlotDomain.fetchParkingSlots().stream()
                .filter(i -> i.getVehicleType().equals(vehicleType))
                .filter(j -> j.getSlotStatus().equals(SlotStatus.AVAILABLE))
                .forEach(i -> {
                    int cnt = vehicleTypeIntegerMap.getOrDefault(i.getFloorId(),0);
                    vehicleTypeIntegerMap.put(i.getFloorId() , cnt + 1);
                });

        for(Map.Entry<Integer,Integer> set : vehicleTypeIntegerMap.entrySet() ) {
            System.out.println("No. of free slots for " + vehicleType +  " on Floor " + set.getKey() + ":" + set.getValue());

        }


    }


    private void freeSlotsDisplay(VehicleType vehicleType , SlotStatus slotStatus) {
        Map<Integer , List<Integer>> floorIdIntegerMap = new HashMap<>();

        parkingSlotDomain.fetchParkingSlots().stream()
                .filter(i -> i.getVehicleType().equals(vehicleType))
                .filter(j -> j.getSlotStatus().equals(slotStatus))
                .forEach(i -> {
                    List<Integer> list = floorIdIntegerMap.getOrDefault(i.getFloorId(),new ArrayList<>());
                    list.add(i.getId());
                    floorIdIntegerMap.put(i.getFloorId() ,list);
                });

        for(Map.Entry<Integer,List<Integer>> set : floorIdIntegerMap.entrySet() ) {
            String commaSeparatedString = set.getValue().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println("Free slots for " + vehicleType + " on Floor " + set.getKey() + ":" + commaSeparatedString);

        }


    }



}
