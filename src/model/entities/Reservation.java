package model.entities;

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

    public long duration() {
        Duration duration = Duration.between(getCheckout(), getCheckin());
        return duration.toDays();
    }

    public String updateDates(LocalDate checkin, LocalDate checkout) {
        LocalDate now = LocalDate.now();
        if (checkin.isBefore(now) || checkout.isAfter(now)) {
           return "Error in reservation: dates must be in future";
        } if (!checkout.isAfter(checkin)) {
         return "Error in reservation :Check-Out date must be after check-in date";
        }
        this.checkin = checkin;
        this.checkout = checkout;
        return null;
    }

    @Override
    public String toString() {
        DateTimeFormatter dt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("Room: %d | Check-in: %s | Check-out: %s",
                getRoomNumber(), getCheckin().format(dt1), getCheckout().format(dt1));
    }


}
