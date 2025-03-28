package com.cargo.dto;

import jakarta.validation.constraints.*;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@XmlRootElement
public class CargoBookingRequest implements Serializable {

    @NotBlank
    @Pattern(regexp = "^[A-Z]{3}$")
    private String origin;
    @NotBlank
    @Pattern(regexp = "^[A-Z]{3}$")
    private String destination;
    @NotBlank
    @Size(max = 255)
    private String description;
    @Positive
    private double weight;
    @NotBlank
    private String shipperName;
    @Pattern(regexp = "[0-9]{10}$")
    private String shipperContact;
    @NotBlank
    private String consigneeName;
    @Pattern(regexp = "^[0-9]{10}$")
    private String consigneeContact;
    @Min(0)
    private double declaredValue;

    public CargoBookingRequest(String origin, String destination, String description, double weight, String shipperName, String shipperContact, String consigneeName, String consigneeContact, double declaredValue) {
        this.origin = origin;
        this.destination = destination;
        this.description = description;
        this.weight = weight;
        this.shipperName = shipperName;
        this.shipperContact = shipperContact;
        this.consigneeName = consigneeName;
        this.consigneeContact = consigneeContact;
        this.declaredValue = declaredValue;
    }

    public CargoBookingRequest() {
    }

    public @NotBlank @Pattern(regexp = "^[A-Z]{3}$") String getOrigin() {
        return origin;
    }

    public void setOrigin(@NotBlank @Pattern(regexp = "^[A-Z]{3}$") String origin) {
        this.origin = origin;
    }

    public @NotBlank @Pattern(regexp = "^[A-Z]{3}$") String getDestination() {
        return destination;
    }

    public void setDestination(@NotBlank @Pattern(regexp = "^[A-Z]{3}$") String destination) {
        this.destination = destination;
    }

    public @NotBlank @Size(max = 255) String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank @Size(max = 255) String description) {
        this.description = description;
    }

    @Positive
    public double getWeight() {
        return weight;
    }

    public void setWeight(@Positive double weight) {
        this.weight = weight;
    }

    public @NotBlank String getShipperName() {
        return shipperName;
    }

    public void setShipperName(@NotBlank String shipperName) {
        this.shipperName = shipperName;
    }

    public @Pattern(regexp = "[0-9]{10}$") String getShipperContact() {
        return shipperContact;
    }

    public void setShipperContact(@Pattern(regexp = "[0-9]{10}$") String shipperContact) {
        this.shipperContact = shipperContact;
    }

    public @NotBlank String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(@NotBlank String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public @Pattern(regexp = "^[0-9]{10}$") String getConsigneeContact() {
        return consigneeContact;
    }

    public void setConsigneeContact(@Pattern(regexp = "^[0-9]{10}$") String consigneeContact) {
        this.consigneeContact = consigneeContact;
    }

    @Min(0)
    public double getDeclaredValue() {
        return declaredValue;
    }

    public void setDeclaredValue(@Min(0) double declaredValue) {
        this.declaredValue = declaredValue;
    }
}
