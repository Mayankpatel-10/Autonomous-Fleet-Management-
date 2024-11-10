package com.fleetmanagement.tests;

import com.fleetmanagement.dao.VehicleDAO;
import com.fleetmanagement.models.Vehicle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class VehicleDAOTest {
    VehicleDAO vehicleDAO = new VehicleDAO();

    @Test
    public void testGetAllVehicles() {
        List<Vehicle> vehicles = vehicleDAO.getAllVehicles();
        assertNotNull(vehicles, "Vehicle list should not be null");
        assertTrue(vehicles.size() >= 0, "Vehicle list size should be >= 0");
    }
}
