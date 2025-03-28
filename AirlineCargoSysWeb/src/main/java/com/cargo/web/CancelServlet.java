package com.cargo.web;


import com.cargo.service.CargoServiceRemote;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

public class CancelServlet extends HttpServlet {
    private static final String JNDI_NAME = "java:global/AirlineCargoSys-0.0.1-SNAPSHOT/AirlineCargoSys-AirlineCargoSysEJB-0.0.1-SNAPSHOT/CargoServiceBean!com.cargo.service.CargoServiceRemote";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String trackingNumber = request.getParameter("trackingNumber");

        try {
            InitialContext ctx = new InitialContext();
            CargoServiceRemote cargoService = (CargoServiceRemote) ctx.lookup(JNDI_NAME);

            boolean cancelled = cargoService.cancelShipment(trackingNumber);

            if (cancelled) {
                request.setAttribute("cancelMessage", "Shipment cancelled successfully!");
            } else {
                request.setAttribute("cancelMessage", "Error: Unable to cancel shipment. Shipment not found or already processed.");
            }
        } catch (NamingException e) {
            request.setAttribute("cancelMessage", "Error while canceling shipment: " + e.getMessage());
        }
        request.getRequestDispatcher("cancel.jsp").forward(request, response);
    }
}
