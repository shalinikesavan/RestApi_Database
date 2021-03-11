package MyVehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MyVehicle.VehicleCreateDTO;
import MyVehicle.VehicleQueryDTO;
import MyVehicle.VehicleUpdateDTO;
import MyVehicle.Status;
import MyVehicle.Vehicle;
import MyVehicle.VehicleRepository;

import java.util.UUID;

@Service
public class VehicleCommandServiceImpl implements VehicleCommandService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public UUID createVehicle(VehicleCreateDTO vehicleCreateDTO) {
        Vehicle newVehicle = new Vehicle();

        newVehicle.setId(UUID.randomUUID());
        newVehicle.setVIN(vehicleCreateDTO.getVIN());
        newVehicle.setMake(vehicleCreateDTO.getMake());
        newVehicle.setModel(vehicleCreateDTO.getModel());
        newVehicle.setStatus(String.valueOf(Status.FOR_SALE));

        return vehicleRepository.save(newVehicle).getId();
    }

    @Override
    public VehicleQueryDTO updateVehicle(UUID id, VehicleUpdateDTO vehicleUpdateDTO) {

        if (vehicleRepository.findById(id).isPresent()){
            Vehicle existingVehicle = vehicleRepository.findById(id).get();

            existingVehicle.setMake(vehicleUpdateDTO.getMake());
            existingVehicle.setModel(vehicleUpdateDTO.getModel());

            Vehicle updatedVehicle = vehicleRepository.save(existingVehicle);

            return new VehicleQueryDTO(updatedVehicle.getId(), updatedVehicle.getVIN(),
                    updatedVehicle.getMake(), updatedVehicle.getModel());
        }else{
            return null;
        }
    }

}
