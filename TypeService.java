package com.mycompany.projetjava;
import java.util.Scanner;
////////////application grasp 

public class TypeService {
    public static void setTypeForProduit(Produit produit, Type[] tabType, int index) {
        Type type = tabType[index];
        produit.getTyp().setNomType(type.getNomType());
        produit.getTyp().setIdType(type.getIdType());
        produit.getTyp().setCat(new Categorie());
        produit.getTyp().getCat().setIdCat(type.getCat().getIdCat());
        produit.getTyp().getCat().setNomCat(type.getCat().getNomCat());
    }
}
