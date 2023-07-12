import DTO.ParkingLotDTO;
import enums.VehicleType;
import service.ParkingBookingService;
import service.ParkingLotService;

import java.util.Scanner;




public class Main {





    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String cmd = scanner.next();
        String parkingLotId = scanner.next();
        int noOfFloor = scanner.nextInt();
        int noOfSlot = scanner.nextInt();

        ParkingLotService parkingLotService = new ParkingLotService();
        ParkingBookingService parkingBookingService = new ParkingBookingService();

        parkingLotService.createParkingLot(new ParkingLotDTO(parkingLotId,noOfFloor,noOfSlot));


        while(scanner.hasNext()) {
            String command = scanner.next();
            if(command.compareTo("park_vehicle") == 0) {
                VehicleType vehicleType = VehicleType.valueOf(scanner.next());
                String registrationNumber = scanner.next();
                String colour  = scanner.next();
                parkingBookingService.bookParkingLot(vehicleType ,registrationNumber,colour);

            }
            else if(command.compareTo("unpark_vehicle") == 0) {
                String ticketId = scanner.next();
                parkingBookingService.unParkLot(ticketId);
            }
            else if(command.compareTo("display") == 0) {
                String displayType = scanner.next();
                VehicleType vehicleType = VehicleType.valueOf(scanner.next());

                parkingLotService.display(displayType,vehicleType);

            }
            else if(command.compareTo("exit") == 0) {
                return ;
            }
        }




    }


}
