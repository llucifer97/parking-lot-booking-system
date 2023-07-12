package DTO;

public class TicketDTO {

    private String parkingLotId;
    private int slotId;
    private int  floorId;

    public TicketDTO(String parkingLotId, int slotId, int floorId) {
        this.parkingLotId = parkingLotId;
        this.slotId = slotId;
        this.floorId = floorId;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }
}
