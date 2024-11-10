package com.fleetmanagement.controllers;

import com.fleetmanagement.dao.VehicleDAO;
import com.fleetmanagement.models.Vehicle;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/vehicles")
public class VehicleController extends HttpServlet {
    private VehicleDAO vehicleDAO = new VehicleDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Vehicle> vehicles = vehicleDAO.getAllVehicles();
        String json = new Gson().toJson(vehicles);

        response.setContentType("application/json");
        response.getWriter().write(json);
    }
}
