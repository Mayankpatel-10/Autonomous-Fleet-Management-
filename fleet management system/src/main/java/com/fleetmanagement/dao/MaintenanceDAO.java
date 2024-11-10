package com.fleetmanagement.dao;

import com.fleetmanagement.models.MaintenanceRecord;
import com.fleetmanagement.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaintenanceDAO {
    public List<MaintenanceRecord> getAllMaintenanceRecords() {
        List<MaintenanceRecord> records = new ArrayList<>();
        String query = "SELECT * FROM maintenance_records";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                records.add(new MaintenanceRecord(
                        rs.getInt("id"),
                        rs.getInt("vehicle_id"),
                        rs.getString("description"),
                        rs.getDate("date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }
}
