package com.fleetmanagement.controllers;

import com.fleetmanagement.dao.MaintenanceDAO;
import com.fleetmanagement.models.MaintenanceRecord;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/maintenance")
public class MaintenanceController extends HttpServlet {
    private MaintenanceDAO maintenanceDAO = new MaintenanceDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MaintenanceRecord> records = maintenanceDAO.getAllMaintenanceRecords();
        String json = new Gson().toJson(records);

        response.setContentType("application/json");
        response.getWriter().write(json);
    }
}