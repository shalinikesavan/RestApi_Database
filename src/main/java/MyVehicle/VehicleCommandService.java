package MyVehicle;

import java.util.UUID;

import MyVehicle.VehicleCreateDTO;
import MyVehicle.VehicleQueryDTO;
import MyVehicle.VehicleUpdateDTO;

public interface VehicleCommandService {

    public UUID createVehicle(VehicleCreateDTO vehicleCreateDTO);
    public VehicleQueryDTO updateVehicle(UUID id, VehicleUpdateDTO vehicleUpdateDTO);

}
