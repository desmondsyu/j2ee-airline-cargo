package com.cargo.web;

import com.cargo.dto.CargoBookingRequest;
import com.cargo.dto.CargoStatus;
import com.cargo.service.CargoServiceRemote;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;


public class BookingServlet extends HttpServlet {
    private static final String JNDI_NAME = "java:global/AirlineCargoSys-0.0.1-SNAPSHOT/AirlineCargoSys-AirlineCargoSysEJB-0.0.1-SNAPSHOT/CargoServiceBean!com.cargo.service.CargoServiceRemote";


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String origin = request.getParameter("origin");
        String destination = request.getParameter("destination");
        String description = request.getParameter("description");
        double weight = Double.parseDouble(request.getParameter("weight"));
        String shipperName = request.getParameter("shipperName");
        String shipperContact = request.getParameter("shipperContact");
        String consigneeName = request.getParameter("consigneeName");
        String consigneeContact = request.getParameter("consigneeContact");
        double declaredValue = Double.parseDouble(request.getParameter("declaredValue"));

        try {
            InitialContext ctx = new InitialContext();
            CargoServiceRemote cargoService = (CargoServiceRemote) ctx.lookup(JNDI_NAME);

            CargoBookingRequest bookingRequest = new CargoBookingRequest(origin, destination, description, weight, shipperName, shipperContact, consigneeName, consigneeContact, declaredValue);
            String trackingNumber = cargoService.bookShipment(bookingRequest);



            request.setAttribute("message", "Shipment booked successfully! Tracking Number: " + trackingNumber);
        } catch (NamingException e) {
            e.printStackTrace();
            request.setAttribute("message", "Error while booking shipment: " + e.getMessage());
        }
        request.getRequestDispatcher("booking.jsp").forward(request, response);
        }
    }

