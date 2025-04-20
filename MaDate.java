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


 /**
 * Représente une date avec des invariants OCL :
 * @inv JJ >= 1 and JJ <= 31
 * @inv MM >= 1 and MM <= 12
 * @inv AA >= 1000 and AA <= 9999
 */

 public class MaDate {
    private int JJ;
    private int MM;
    private int AA;

//les Invariants OCL

    // Constructeur avec validation OCL
    public MaDate(int j, int m, int a) {
        this.setJJ(j);
        this.setMM(m);
        this.setAA(a);
    }

    // Setters avec validation OCL
    public void setJJ(int j) {
        if (j < 1 || j > 31) throw new IllegalArgumentException("Jour invalide (1-31)");
        this.JJ = j;
    }

    public void setMM(int m) {
        if (m < 1 || m > 12) throw new IllegalArgumentException("Mois invalide (1-12)");
        this.MM = m;
    }

    public void setAA(int a) {
        if (a < 1000 || a > 9999) throw new IllegalArgumentException("Année invalide (1000-9999)");
        this.AA = a;
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


/** 
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
    }**/



    public static void InitDate(MaDate maDate, Scanner scanner) {
        System.out.println("* Saisie de la date *");
        
       // int j, m, a;
        do {
            System.out.println("* Jour (1-31) : ");
            j = scanner.nextInt();
        } while (j < 1 || j > 31);  // Validation interactive
    
        // Idem pour mois et année...
        maDate.setJJ(j);
        maDate.setMM(m);
        maDate.setAA(a);
    }

  

   

}
