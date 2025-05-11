package com.mycompany.projetjava.formatters;

import com.mycompany.projetjava.Type;
import com.mycompany.projetjava.TypeFormatter;

/////application solid
public class FormatterDetaille implements TypeFormatter {
    public void afficher(Type type) {
        System.out.println("Type : " + type.getNomType() + " | ID: " + type.getIdType());
    }
}

