/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetjava;
import java.util.Scanner;

import javax.swing.text.DateFormatter;
/**
 *
 * @author 
 */

public class MaDate {
    private int JJ;
    private int MM;
    private int AA;


    // Class invariant: date must be valid
    private boolean invariant() {
        return isValidDate(JJ, MM, AA);
    }

    private boolean isValidDate(int day, int month, int year) {
        if (year < 1000 || year > 9999) return false;
        if (month < 1 || month > 12) return false;
        
        int maxDay;
        switch (month) {
            case 2:
                maxDay = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) ? 29 : 28;
                break;
            case 4: case 6: case 9: case 11:
                maxDay = 30;
                break;
            default:
                maxDay = 31;
        }
        return day >= 1 && day <= maxDay;
    }

    public MaDate() {
        this.JJ = 1;
        this.MM = 1;
        this.AA = 2025;
        assert invariant();
    }

    public MaDate(int j, int m, int a) {
        if (!isValidDate(j, m, a)) {
            throw new IllegalArgumentException("Invalid date");
        }
        this.JJ = j;
        this.MM = m;
        this.AA = a;
        assert invariant();
    }

    // ... (rest of the getters and setters with validation)

    public void setJJ(int JJ) {
        if (!isValidDate(JJ, this.MM, this.AA)) {
            throw new IllegalArgumentException("Invalid day for current month/year");
        }
        this.JJ = JJ;
        assert invariant();
    }

    public void setMM(int MM) {
        if (!isValidDate(this.JJ, MM, this.AA)) {
            throw new IllegalArgumentException("Invalid month for current day/year");
        }
        this.MM = MM;
        assert invariant();
    }

     public void setAA(int AA) {
        if (!isValidDate(this.JJ, this.MM, AA)) {
            throw new IllegalArgumentException("Invalid year for current day/month");
        }
        this.AA = AA;
        assert invariant();
    }

/** 
    public MaDate(){
        JJ=01;
        MM=01;
        AA=2025;
    };**/

    //////application OCL ici
  /**   public MaDate(int jour, int mois, int annee) {
        if (jour < 1 || jour > 31) {
            throw new IllegalArgumentException("Jour invalide");
        }
        if (mois < 1 || mois > 12) {
            throw new IllegalArgumentException("Mois invalide");
        }
        if (annee < 0) {
            throw new IllegalArgumentException("Année invalide");
        }
        this.JJ = jour;
        this.MM = mois;
        this.AA = annee;
    }**/


    public int getJJ() {
        return JJ;
    }

    public int getMM() {
        return MM;
    }

    public int getAA() {
        return AA;
    }
/** 
    public void setJJ(int JJ) {
        this.JJ = JJ;
    }

    public void setMM(int MM) {
        this.MM = MM;
    }

    public void setAA(int AA) {
        this.AA = AA;
    }**/
    public static void InitDate(MaDate maDate, Scanner scanner) {
        System.out.println("*  Vous allez saisir la date.                                *");

        do {
            System.out.println("*  Veuillez saisir le jour sous forme JJ                     *");
            maDate.JJ = scanner.nextInt();
        } while (maDate.JJ < 1 || maDate.JJ > 31);

        do {
            System.out.println("*  Veuillez saisir le mois sous forme MM                     *");
            maDate.MM = scanner.nextInt();
        } while (maDate.MM < 1 || maDate.MM > 12);

        do {
            System.out.println("*  Veuillez saisir l'annee sous forme AAAA                   *");
            maDate.AA = scanner.nextInt();
        } while (maDate.AA < 1000 || maDate.AA > 9999);
    }

  

   

}
