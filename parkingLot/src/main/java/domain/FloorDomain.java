package domain;

import DTO.FloorDTO;
import model.Floor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FloorDomain {

    private List<Floor> floorList;


    public FloorDomain() {
        this.floorList = new ArrayList<>();
    }

    public Floor createFloor(FloorDTO floorDTO) {

        Floor floor = new Floor();
        if(!floorList.isEmpty()) {
            int idx = floorList.stream().sorted().collect(Collectors.toList()).get(0).getFloorId() + 1;
            floor.setFloorId(idx);
        }
        else {
            floor.setFloorId(1);
        }

        floorList.add(floor);
        return floor;
    }

    public List<Floor> fetchFloorList() {
        return floorList;
    }
}
