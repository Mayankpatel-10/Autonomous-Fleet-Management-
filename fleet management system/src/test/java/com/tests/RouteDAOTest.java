package com.fleetmanagement.tests;

import com.fleetmanagement.dao.RouteDAO;
import com.fleetmanagement.models.Route;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class RouteDAOTest {
    RouteDAO routeDAO = new RouteDAO();

    @Test
    public void testGetAllRoutes() {
        List<Route> routes = routeDAO.getAllRoutes();
        assertNotNull(routes, "Route list should not be null");
        assertTrue(routes.size() >= 0, "Route list size should be >= 0");
    }
}
