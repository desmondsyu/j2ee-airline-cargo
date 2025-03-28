package com.cargo.web;

import com.cargo.dto.CargoEvent;
import com.cargo.dto.CargoStatus;
import com.cargo.service.CargoServiceRemote;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;



public class UpdateServlet extends HttpServlet {
    private static final String JNDI_NAME = "java:global/AirlineCargoSys-0.0.1-SNAPSHOT/AirlineCargoSys-AirlineCargoSysEJB-0.0.1-SNAPSHOT/CargoServiceBean!com.cargo.service.CargoServiceRemote";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String trackingNumber = request.getParameter("trackingNumber");
        String eventStatus = request.getParameter("eventStatus");

        try {
            InitialContext ctx = new InitialContext();
            CargoServiceRemote cargoService = (CargoServiceRemote) ctx.lookup(JNDI_NAME);

            CargoStatus status = CargoStatus.valueOf(eventStatus);
            CargoEvent cargoEvent = new CargoEvent( status);

            boolean updated = cargoService.updateShipmentEvent(trackingNumber, cargoEvent);

            if (updated) {
                request.setAttribute("updateMessage", "Shipment updated successfully!");
            } else {
                request.setAttribute("updateMessage", "Error: Invalid tracking number or event.");
            }
        } catch (NamingException | IllegalArgumentException e) {
            request.setAttribute("updateMessage", "Error updating shipment: " + e.getMessage());
        }
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }
}
