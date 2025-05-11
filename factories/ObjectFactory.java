package com.mycompany.projetjava.factories;

public class ObjectFactory {
    // Méthode pour créer une Catégorie
    public static Categorie createCategorie(int id, String nom) {
        return new Categorie(id, nom);
    }

    // Méthode pour créer un Type (avec une Catégorie associée)
    public static Type createType(int id, String nom, Categorie cat) {
        return new Type(id, nom, cat);
    }

    // Méthode pour créer un Produit (avec un Type et une Date)
    public static Produit createProduit(int id, String nom, Type typ, MaDate date) {
        return new Produit(id, nom, typ, date);
    }
}