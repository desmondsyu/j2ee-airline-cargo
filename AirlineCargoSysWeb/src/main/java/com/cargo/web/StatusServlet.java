package com.cargo.web;



import com.cargo.service.CargoServiceRemote;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

@WebServlet("/StatusServlet")
public class StatusServlet extends HttpServlet {
    private static final String JNDI_NAME = "java:global/AirlineCargoSys-0.0.1-SNAPSHOT/AirlineCargoSys-AirlineCargoSysEJB-0.0.1-SNAPSHOT/CargoServiceBean!com.cargo.service.CargoServiceRemote";



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String trackingNumber = request.getParameter("trackingNumber");

        try {
            InitialContext ctx = new InitialContext();
            CargoServiceRemote cargoService = (CargoServiceRemote) ctx.lookup(JNDI_NAME);

            String status = cargoService.getShipmentStatus(trackingNumber);
            if (status != null) {
                request.setAttribute("statusMessage", "Shipment Status: " + status);
            } else {
                request.setAttribute("statusMessage", "Tracking number not found.");
            }
        } catch (NamingException e) {
            e.printStackTrace();
            request.setAttribute("statusMessage", "Error retrieving shipment status: " + e.getMessage());
        }
        request.getRequestDispatcher("status.jsp").forward(request, response);
    }
}
