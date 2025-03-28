package com.cargo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.time.LocalDateTime;

@XmlRootElement
public class CargoEvent implements Serializable {
    @NotEmpty
    private CargoStatus cargoStatus;
    @NotBlank
    @Size(max = 100)
    private String location;
    @NotNull
    private LocalDateTime timestamp;
    @Size(max = 512)
    private String notes;

    public CargoEvent(CargoStatus cargoStatus, String location, LocalDateTime timestamp, String notes) {
        this.cargoStatus = cargoStatus;
        this.location = location;
        this.timestamp = timestamp;
        this.notes = notes;
    }

    public CargoEvent(CargoStatus cargoStatus, String location, LocalDateTime timestamp) {
        this(cargoStatus, location, timestamp, "");
    }

    @NotEmpty
    public CargoStatus getCargoStatus() {
        return cargoStatus;
    }

    public void setCargoStatus(@NotEmpty CargoStatus cargoStatus) {
        this.cargoStatus = cargoStatus;
    }

    public @NotBlank @Size(max = 100) String getLocation() {
        return location;
    }

    public void setLocation(@NotBlank @Size(max = 100) String location) {
        this.location = location;
    }

    public @NotNull LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(@NotNull LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public @Size(max = 512) String getNotes() {
        return notes;
    }

    public void setNotes(@Size(max = 512) String notes) {
        this.notes = notes;
    }
}
