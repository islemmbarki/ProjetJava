/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.projetjava.product;
import com.mycompany.projetjava.MaDate;
import com.mycompany.projetjava.Type;

import java.util.Scanner;

public class Produit {
    int id ;
    public String  Nom;
    Type Typ ;
    MaDate Date_expiration ;


    //Principe du GRASP Creator

    /**public Produit(int id, String nom, Type typ, MaDate date) {
        this.id = id;
        this.Nom = nom;
        this.Typ = typ; // Reçoit un Type existant
        this.Date_expiration = date;
    }**/

    public Produit(int id, String nom, int idType, String nomType, int idCat, String nomCat, MaDate date) {
        this.id = id;
        this.Nom = nom;
        this.Typ = new Type(idType, nomType, idCat, nomCat); // Crée son propre Type
        this.Date_expiration = date;
    }

    public Produit() {
        this(0, "New Product", new Type(), new MaDate());
    }

    public void setDate_expiration(MaDate date) {
        if (date == null) {
            throw new IllegalArgumentException("La date ne peut pas être null");
        }
        this.Date_expiration = date;  // Validation OCL déjà gérée par MaDate
    }

    
  
}







    

/** 
    // Constructor is now private to enforce factory usage
    public Produit(int id, String nom, Type typ, MaDate dateExpiration) {
        this.id = id;
        this.nom = nom;
        this.typ = typ;
        this.dateExpiration = dateExpiration;
        assert invariant();
    }**/

    // Default constructor remains for compatibility
