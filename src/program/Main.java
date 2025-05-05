package program;

import model.entities.Reservation;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        int n = 0;
        String updateConfirm = "";
        DateTimeFormatter dt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to our Reservation System");
        List<Reservation> reservationList = new ArrayList<>();

        System.out.println("------How many reservations?------");
        n = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < n; i++) {
            Reservation reservation = new Reservation();
            System.out.println("---Reservation #" + (i + 1));

            System.out.println("--Room Number:");
            Integer roomNumber = scan.nextInt();
            scan.nextLine();
            reservation.setRoomNumber(roomNumber);

            System.out.println("--Enter Check-In (dd/MM/yyyy):");
            LocalDate checkin = LocalDate.parse(scan.nextLine(), dt1);

            System.out.println("--Enter Check-Out (dd/MM/yyyy):");
            LocalDate checkout = LocalDate.parse(scan.nextLine(), dt1);

            while (!checkout.isAfter(checkin)) {
                System.out.println("Error in reservation :Check-Out date must be after check-in date");

                System.out.println("Tap the check-In again(dd/MM/yyyy):");
                checkin = LocalDate.parse(scan.nextLine(), dt1);

                System.out.println("Check-Out date again(dd/MM/yyyy):");
                checkout = LocalDate.parse(scan.nextLine(), dt1);

                reservationList.add(new Reservation());
                System.out.println("RESERVATION CONFIRMED");

                System.out.println("----Do you want to do an Update?(s/n)----");
                updateConfirm = scan.nextLine();
                while (!updateConfirm.equalsIgnoreCase("s") && !
                        updateConfirm.equalsIgnoreCase("n")) {

                    System.out.println("---- Tap a valid answer please ----");
                    System.out.println("----Do you want to do an Update?(s/n)----");
                    updateConfirm = scan.nextLine();
                }
                if (updateConfirm.equalsIgnoreCase("s")) {
                    System.out.println("---Enter Data update:---");
                    System.out.println("Check-In date(dd/MM/yyyy)");
                    LocalDate checkinUpdate = LocalDate.parse(scan.nextLine(), dt1);

                    System.out.println("Check-Out date(dd/MM/yyyy)");
                    LocalDate checkoutUpdate = LocalDate.parse(scan.nextLine(), dt1);
                    String error = reservation.updateDates(checkinUpdate, checkoutUpdate);
                    if (error != null) {
                        System.out.println("Error in reservation: " + error);
                    } else {
                        System.out.println("RESERVATION UPDATED");
                        System.out.println("Reservation: " + reservation);
                    }
                }
            }
        }
    }
}
