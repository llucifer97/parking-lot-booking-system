package strategy;

public class ParkingLotBookingFactory {



    private final String BASIC = "default";





    public ParkingLotBookingStrategy from(String algorithm) {


        switch (algorithm) {
            case BASIC:
                return new DefaultParkingLotStrategyImpl();
        }

        throw new IllegalArgumentException("Invalid algorithm : " + algorithm);

    }

}
