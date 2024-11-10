package com.fleetmanagement.dao;

import com.fleetmanagement.models.Route;
import com.fleetmanagement.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RouteDAO {
    public List<Route> getAllRoutes() {
        List<Route> routes = new ArrayList<>();
        String query = "SELECT * FROM routes";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                routes.add(new Route(
                        rs.getInt("id"),
                        rs.getString("start_location"),
                        rs.getString("end_location"),
                        rs.getDouble("distance")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return routes;
    }
}
