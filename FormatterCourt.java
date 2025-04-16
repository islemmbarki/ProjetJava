package com.mycompany.projetjava;

/////application solid

public class FormatterCourt implements TypeFormatter {
    public void afficher(Type type) {
        System.out.println("Type : " + type.getNomType());
    }
}
