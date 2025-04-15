/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetjava;
import java.util.Scanner;
/**
 *
 * @author 
 */

public class MaDate {
    private int JJ;
    
    private int MM;
    private int AA;
    public MaDate(){
        JJ=01;
        MM=01;
        AA=2025;
    };
    public MaDate(int j,int m, int a){
        JJ=j;
        MM=m;
        AA=a;
    }

    public int getJJ() {
        return JJ;
    }

    public int getMM() {
        return MM;
    }

    public int getAA() {
        return AA;
    }

    public void setJJ(int JJ) {
        this.JJ = JJ;
    }

    public void setMM(int MM) {
        this.MM = MM;
    }

    public void setAA(int AA) {
        this.AA = AA;
    }
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
