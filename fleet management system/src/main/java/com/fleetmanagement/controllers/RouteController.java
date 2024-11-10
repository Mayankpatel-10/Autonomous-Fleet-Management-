package com.fleetmanagement.controllers;

import com.fleetmanagement.dao.RouteDAO;
import com.fleetmanagement.models.Route;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/routes")
public class RouteController extends HttpServlet {
    private RouteDAO routeDAO = new RouteDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Route> routes = routeDAO.getAllRoutes();
        String json = new Gson().toJson(routes);

        response.setContentType("application/json");
        response.getWriter().write(json);
    }
}
