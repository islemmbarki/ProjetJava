package com.mycompany.projetjava.services;

import java.util.Scanner;
import com.mycompany.projetjava.MaDate;;


    public class DateService {
    public static void initExpirationDate(MaDate dateExpiration, Scanner scanner) {
        MaDate.InitDate(dateExpiration, scanner);
    }

    public boolean isExpired(MaDate date) {
        return false;

    }
}


