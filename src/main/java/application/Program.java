package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        // metodo de conversão da String em foramato Date pode gerar uma excessão,
        //  a execção pode ser tratada neste método main usando try catch ou
        //  propagar para outro metodo, no caso usamos throws ParseException
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room Number");
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy) ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy) ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println(" ");
            System.out.println("Enter data to update reservation: ");
            System.out.print("Check-in date: ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date: ");
            checkOut = sdf.parse(sc.next());

            Date now = new Date();
            if ((checkOut.before(now)) || (checkIn.before(now))) {
                System.out.println("Error in reservation: Reservations dates must be future dates");
            } else if (!checkOut.after(checkIn)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            } else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation updated: " + reservation);
            }

        }
        sc.close();
        }
    }
