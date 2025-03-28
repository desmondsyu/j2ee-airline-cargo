package com.cargo.service.impl;

import com.cargo.dto.CargoBookingRequest;
import com.cargo.dto.CargoEvent;
import com.cargo.dto.CargoShipment;
import com.cargo.dto.CargoStatus;
import com.cargo.service.CargoServiceRemote;
import jakarta.ejb.Stateless;
import jakarta.jws.WebService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Stateless
@WebService(endpointInterface = "com.example.ejb.CargoServiceRemote")
public class CargoServiceBean implements CargoServiceRemote {
    private static final Map<String, CargoShipment> cargoShipmentMap = new HashMap<>();

    @Override
    public String bookShipment(CargoBookingRequest request) {
        String trackingNumber = "SLA" + System.currentTimeMillis();
        CargoShipment cargoShipment = new CargoShipment(trackingNumber, request, CargoStatus.BOOKED);
        cargoShipmentMap.put(trackingNumber, cargoShipment);
        return trackingNumber;
    }

    @Override
    public String getShipmentStatus(String trackingNumber) {
        CargoShipment cargoShipment = cargoShipmentMap.get(trackingNumber);
        return cargoShipment != null ? cargoShipment.getStatus().toString() : null;
    }

    @Override
    public boolean updateShipmentEvent(String trackingNumber, CargoEvent cargoEvent){
        CargoShipment cargoShipment = cargoShipmentMap.get(trackingNumber);
        if(cargoShipment == null){
            return false;
        }
        cargoShipment.getEventHistory().add(cargoEvent);
        cargoShipment.setStatus(cargoEvent.getCargoStatus());
        return true;
    }

    @Override
    public boolean cancelShipment(String trackingNumber) {
        CargoShipment cargoShipment = cargoShipmentMap.get(trackingNumber);
        if (cargoShipment == null || !"BOOKED".equals(cargoShipment.getStatus().toString())) {
            cargoShipment.setStatus(CargoStatus.CANCELLED);
        }
        return true;
    }

    @Override
    public List<CargoShipment> getShipmentByShipper(String shipperName){
        return cargoShipmentMap.values().stream()
                .filter(s -> shipperName.equalsIgnoreCase(s.getBookingDetails().getShipperName()))
                .collect(Collectors.toList());
    }
}
