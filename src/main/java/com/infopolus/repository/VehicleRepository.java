package com.infopolus.repository;

import com.infopolus.entiry.Vehicle;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleRepository {

  private final List<Vehicle> allVehicles = new ArrayList<>();

  public void createProducts() {
    allVehicles.add(new Vehicle(1, 1, "Mercedes"));
    allVehicles.add(new Vehicle(2, 1, "Mercedes"));
    allVehicles.add(new Vehicle(3, 1, "Porsche"));
    allVehicles.add(new Vehicle(4, 2, "Mercedes"));
    allVehicles.add(new Vehicle(5, 2, "Mercedes"));
    allVehicles.add(new Vehicle(6, 3, "Mercedes"));
    allVehicles.add(new Vehicle(7, 3, "MG"));
    allVehicles.add(new Vehicle(8, 4, "Tesla"));
    allVehicles.add(new Vehicle(9, 5, "Lada"));
  }

  public List<Vehicle> getAllVehicles() {
    return allVehicles;
  }

  public void save(Vehicle vehicle) {
    if (vehicle.getOwnerId() < 0 || vehicle.getModel().isEmpty()) {
      throw new IllegalArgumentException();
    }
    vehicle.setId(allVehicles.size());
    allVehicles.add(vehicle);
  }

  public void saveAll(List<Vehicle> vehicles) {
    vehicles.forEach(this::save);
  }

  public Vehicle deleteById(int id) {
    allVehicles.removeIf(x -> x.getId() == (id));
    return null;
  }

  public List<Vehicle> findAllByOwnerId(int ownerId) {
    if (ownerId < 0) {
      return null;
    }
    return allVehicles.stream().filter(vehicle -> vehicle.getOwnerId() == (ownerId)).collect(Collectors.toList());
  }

}
