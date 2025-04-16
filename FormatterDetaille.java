package com.mycompany.projetjava;

/////application solid
public class FormatterDetaille implements TypeFormatter {
    public void afficher(Type type) {
        System.out.println("Type : " + type.getNomType() + " | ID: " + type.getIdType());
    }
}

