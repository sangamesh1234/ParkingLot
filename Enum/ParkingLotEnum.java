package LowLevelDesign.ParkingLot.Enum;

import LowLevelDesign.ParkingLot.DTO.Parkingspot.Compact;
import LowLevelDesign.ParkingLot.DTO.Parkingspot.Large;
import LowLevelDesign.ParkingLot.DTO.Parkingspot.Mini;

public enum ParkingLotEnum {
    COMPACT(Compact.class),
    MINI(Mini.class),
    LARGE(Large.class);

    public Class aClass;

    ParkingLotEnum(Class aClass) {
        this.aClass = aClass;
    }

    public Class getVehicleType() {
        return aClass;
    }
}
