package com.mycompany.projetjava;
import com.mycompany.projetjava.Categorie;

////application adapter
    public class CategorieAdapter implements Printable {
    private Categorie categorie;

    public CategorieAdapter(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public void print() {
        System.out.println("Nom de la catégorie : " + categorie.getNomCat());
    }
}

