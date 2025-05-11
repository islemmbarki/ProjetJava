package com.mycompany.projetjava.formatters;

/////application solid

import com.mycompany.projetjava.Type;
import com.mycompany.projetjava.TypeFormatter;

public class FormatterCourt implements TypeFormatter {
    public void afficher(Type type) {
        System.out.println("Type : " + type.getNomType());
    }
}
