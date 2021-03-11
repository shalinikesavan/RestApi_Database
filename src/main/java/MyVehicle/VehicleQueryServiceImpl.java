package MyVehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MyVehicle.VehicleQueryDTO;
import MyVehicle.Vehicle;
import MyVehicle.VehicleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class VehicleQueryServiceImpl implements VehicleQueryService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public VehicleQueryDTO getVehicle(UUID id) {
        if (vehicleRepository.findById(id).isPresent()){
            Vehicle fetchedVehicle = vehicleRepository.findById(id).get();
            return new VehicleQueryDTO(fetchedVehicle.getId(), fetchedVehicle.getVIN(), fetchedVehicle.getMake(), fetchedVehicle.getModel());
        }else{
            return null;
        }
    }

    @Override
    public List<VehicleQueryDTO> listAllVehicles() {
        List<VehicleQueryDTO> vehicleList = new ArrayList<>();

        vehicleRepository.findAll().forEach(vehicle -> {
            vehicleList.add(new VehicleQueryDTO(vehicle.getId(), vehicle.getVIN(), vehicle.getMake(), vehicle.getModel()));
        });

        return vehicleList;
    }
}
