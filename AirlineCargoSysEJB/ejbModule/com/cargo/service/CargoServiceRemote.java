package com.cargo.service;

import com.cargo.dto.CargoBookingRequest;
import com.cargo.dto.CargoEvent;
import com.cargo.dto.CargoShipment;
import jakarta.ejb.Remote;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@Remote
@WebService
public interface CargoServiceRemote {
    @WebMethod
    String bookShipment(CargoBookingRequest request);

    @WebMethod
    String getShipmentStatus(String trackingNumber);

    @WebMethod
    boolean updateShipmentEvent(String trackingNumber, CargoEvent cargoEvent);

    @WebMethod
    boolean cancelShipment(String trackingNumber);

    @WebMethod
    List<CargoShipment> getShipmentByShipper(String shipperName);
}
