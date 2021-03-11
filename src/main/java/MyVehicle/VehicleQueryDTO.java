package MyVehicle;

import java.util.UUID;

public class VehicleQueryDTO {

    private UUID id;

    private String VIN;

    private String make;

    private String model;

    public VehicleQueryDTO(UUID id, String VIN, String make, String model) {
        this.id = id;
        this.VIN = VIN;
        this.make = make;
        this.model = model;
    }

    public UUID getId() {
        return id;
    }

    public String getVIN() {
        return VIN;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "VehicleQueryDTO{" +
                "id=" + id +
                ", VIN='" + VIN + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
