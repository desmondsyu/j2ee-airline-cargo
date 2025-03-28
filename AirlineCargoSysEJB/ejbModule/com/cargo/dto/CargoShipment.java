package com.cargo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class CargoShipment implements Serializable {

    private static int trackingId = 1;

    private final int trackingNumber;
    @NotNull
    private CargoBookingRequest bookingDetails;
    @NotNull
    private CargoStatus status;
    private final List<CargoEvent> eventHistory = new ArrayList<>();

    public CargoShipment(CargoBookingRequest bookingDetails, CargoStatus status) {
        this.trackingNumber = trackingId++;
        this.bookingDetails = bookingDetails;
        this.status = status;
    }

    public int getTrackingNumber() {
        return trackingNumber;
    }

    @NotNull
    public CargoBookingRequest getBookingDetails() {
        return bookingDetails;
    }

    @NotNull
    public CargoStatus getStatus() {
        return status;
    }

    public List<CargoEvent> getEventHistory() {
        return eventHistory;
    }

    public void setBookingDetails(@NotNull CargoBookingRequest bookingDetails) {
        this.bookingDetails = bookingDetails;
    }

    public void setStatus(@NotNull CargoStatus status) {
        this.status = status;
    }

    public void addEvent(CargoEvent event) {
        this.eventHistory.add(event);
    }
}
