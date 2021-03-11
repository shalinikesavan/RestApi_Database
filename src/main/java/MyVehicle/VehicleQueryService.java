package MyVehicle;

import java.util.List;
import java.util.UUID;

import MyVehicle.VehicleQueryDTO;

public interface VehicleQueryService {

    public VehicleQueryDTO getVehicle(UUID id);
    public List<VehicleQueryDTO> listAllVehicles();
}
