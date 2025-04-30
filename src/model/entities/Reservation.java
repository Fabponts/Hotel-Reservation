package model.entities;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private Integer roomNumber;
    private LocalDate checkin;
    private LocalDate checkout;

    public Reservation() {
    }

    public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public Integer duration() {
        Duration duration = Duration.between(getCheckout(), getCheckin());
        return (int) duration.toDays();
    }

    public void updateDates(LocalDate checkin, LocalDate checkout) {
            this.checkin = checkin;
            this.checkout = checkout;
        }
    public String toString() {
        DateTimeFormatter dt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("Room: %d | Check-in: %s | Check-out: %s | %d nights",
                getRoomNumber(), getCheckin().format(dt1), getCheckout().format(dt1),duration());
    }


}
