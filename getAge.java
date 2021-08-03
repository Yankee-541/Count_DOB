/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GetAge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class getAge {

    private static int year, month, date, yearFuture, leapOrNotLeap;

    public static void main(String[] args) throws ParseException {
        String strDayOfBirth = checkDayOfBirth();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d = sdf.parse(strDayOfBirth);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH) + 1;
        date = c.get(Calendar.DATE);
        LocalDate dob = LocalDate.of(year, month, date);
        LocalDate now1 = LocalDate.now();
        Period diff1 = Period.between(dob, now1); // find the age from day of birth
        

        // Birth day of the current
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        yearFuture = now1.getYear();
//        LocalDate nextDOB = LocalDate.of(yearFuture, month, date);
//        isLeap(yearFuture);
//
//        //The date of birth turns into a string
//        String fDOBString = dob.format(formatter);
//        String fNOWString = now1.format(formatter);
//        String fNextDOBString = nextDOB.format(formatter);
//
//        // Format string into the date
//        Date dateDOB;
//        Date dateCurrent;
//        dateDOB = sdf.parse(fNextDOBString);
//        dateCurrent = sdf.parse(fNOWString);
//
//        // Calculate the day of birth
//        if (dateDOB.before(dateCurrent)) { //check date of birth before date current
//            long difference = Math.abs(dateCurrent.getTime() - dateDOB.getTime());
//            long differenceDates = isLeap(yearFuture) - (difference / (24 * 60 * 60 * 1000)); // if year current is leap (366 - differenceDates)
//            if (differenceDates == 0) {
//                System.out.println("Happy birth day !");
//            } else {
//                System.out.println(differenceDates + " days left is your birthday");
//            }
//
//        } else {
//            long difference = Math.abs(dateDOB.getTime() - dateCurrent.getTime());
//            long differenceDates = difference / (24 * 60 * 60 * 1000);
//
//            if (differenceDates == 0) {
//                System.out.println("Happy birth day !");
//            } else {
//                System.out.println(differenceDates + " days left is your birthday");
//            }
//        }
        System.out.println("You: " + diff1.getYears() + " year old");

//        System.out.println("Day of birth: " + fDOBString);
//        System.out.println("Today: " + fNOWString);
    }

    // check year current is leap or not leap
    private static int isLeap(int yearFutureCheck) {
        boolean checkLeap;
        if (yearFutureCheck % 4 == 0) {
            if (yearFutureCheck % 100 == 0) {
                if (yearFutureCheck % 400 == 0) {
                    checkLeap = true;
                } else {
                    checkLeap = false;
                }
            } else {
                checkLeap = true;
            }
        } else {
            checkLeap = false;
        }
        if (checkLeap == true) {
            leapOrNotLeap = 366;
        } else {
            leapOrNotLeap = 365;
        }
        return leapOrNotLeap;
    }

    private static String checkDayOfBirth() {
        boolean check;
        String strDayOfBirth, rexgexDayOfBirth;
        Scanner scanner = new Scanner(System.in);
        do {
            rexgexDayOfBirth = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
            System.out.println("Your birth is: ");
            strDayOfBirth = scanner.nextLine();
            check = strDayOfBirth.matches(rexgexDayOfBirth);
            if (!check) {
                System.out.println("You must enter a date dd/MM/yyyy !");
            }
        } while (!check);
//            strDayOfBirth.l;
        return strDayOfBirth;
    }
}
