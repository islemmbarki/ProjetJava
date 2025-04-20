/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 * Modified to include creator method (GRASP Creator)
 */
package com.mycompany.projetjava;
import java.util.Scanner;
/**
 *
 * @author 
 */
public class Type {
    int idType;
    String nomType;
    Categorie cat;


    
///application solid
    private TypeFormatter formatter;

    /**public Type() {
        this.idType = 0;
        this.nomType = "";
    }**/

/////application solid aussi 
    public Type(int idType, String nomType, Categorie categ , TypeFormatter formatter) {
        this.idType = idType;
        this.nomType = nomType;
        this.cat = categ;
        this.formatter = formatter;
    }

    //Principe du GRASP Creator
    
    /** public Type(int id, String nom, Categorie cat) {
    this.idType = id;
    this.nomType = nom;
    this.cat = cat; // Reçoit une Catégorie existante
}**/
    public Type(int id, String nom, int idCat, String nomCat) {
        this.idType = id;
        this.nomType = nom;
        this.cat = new Categorie(idCat, nomCat); // Crée sa propre Catégorie
    }


    public int getIdType() {
        return idType;
    }

    public String getNomType() {
        return nomType;
    }

    public Categorie getCat() {
        return cat;
    }
    public void setIdType(int idType) {
        this.idType = idType;
    }

    public void setNomType(String nomType) {
        this.nomType = nomType;
    }

    public void setCat(Categorie cat) {
        this.cat = cat;
    }
        
    public static int TypeExiste(Type[] TabType, int NbType, Type Typ) {
        for (int i = 0; i < NbType; i++) {
            if (TabType[i] != null && TabType[i].idType == Typ.idType) {
                return i;
            }
        }
        return -1;
    }


    class TypeService {
        public static void InitType(Type typ, Categorie[] TabCat, int NbCat, Scanner scanner) {
            // ... implementation
            System.out.println("*  Veuillez entrer le nom du Type                            *");
            Typ.setNomType(scanner.next());
    
            System.out.println("*  Veuillez entrer l'id du Type                              *");
            Typ.setIdType(scanner.nextInt());
    
            System.out.println("*  Veuillez choisir une des categories suivantes             *");
            for (int i = 0; i < NbCat; i++) {
                System.out.println("*    " + TabCat[i].idCat + "-" + TabCat[i].getNomCat() + "\t");
            }

            int id = scanner.nextInt();
            int i = 0;
            while (i != NbCat && TabCat[i].idCat != id) {
                i++;
            }
            if (i < NbCat) {
                Typ.setCat(TabCat[i]);
            } else {
                System.out.println("Invalid category ID entered.");
            }
        }
        
        public static void AjouterType(Type Typ, Type[] TabType, int NbType, Categorie[] TabCat, 
                                     int NbCat, int[] TabQte, Scanner scanner) {
            // ... implementation
            if (NbType < 50 && TypeExiste(TabType, NbType, Typ) == -1) {
                TabType[NbType] = Typ;
                TabQte[NbType] = 0;
                NbType++;
                System.out.println("***************          Type ajoute          ****************");
            } else {
                System.out.println("***************        Ajout impossible       ****************");
            }
        }
/** 
    public static void InitType(Type Typ,Categorie TabCat[],int NbCat,Scanner scanner){
        System.out.println("*  Veuillez entrer le nom du Type                            *");
        Typ.setNomType(scanner.next());

        System.out.println("*  Veuillez entrer l'id du Type                              *");
        Typ.setIdType(scanner.nextInt());

        System.out.println("*  Veuillez choisir une des categories suivantes             *");
        for (int i = 0; i < NbCat; i++) {
            System.out.println("*    " + TabCat[i].idCat + "-" + TabCat[i].getNomCat() + "\t");
        }

        int id = scanner.nextInt();
        int i = 0;
        while (i != NbCat && TabCat[i].idCat != id) {
            i++;
        }
        if (i < NbCat) {
            Typ.setCat(TabCat[i]);
        } else {
            System.out.println("Invalid category ID entered.");
        }
    }**/

    
  /**   public static void AjouterType(Type Typ,Type[] TabType, int NbType, Categorie[] TabCat, int NbCat, int[] TabQte, Scanner scanner) {
        InitType(Typ, TabCat, NbCat, scanner);
        if (NbType < 50 && TypeExiste(TabType, NbType, Typ) == -1) {
            TabType[NbType] = Typ;
            TabQte[NbType] = 0;
            NbType++;
            System.out.println("***************          Type ajoute          ****************");
        } else {
            System.out.println("***************        Ajout impossible       ****************");
        }
    }
    **/
    public static void SupprimerType(Type[] TabType, int NbType, int[] TabQte, Scanner scanner) {
        System.out.println("* Quelle type souhaitez-vous supprimer?                       *");

        for (int i = 0; i < NbType; i++) {
            System.out.printf("%d-%s\t", TabType[i].idType, TabType[i].nomType);
        }
        System.out.println();

        int idType = scanner.nextInt();
        int i = 0;
        while (i < NbType && TabType[i].idType != idType) {
            i++;
        }

        if (i < NbType) {
            if (TabQte[i] == 0) {
                for (; i < NbType - 1; i++) {
                    TabType[i] = TabType[i + 1];
                    TabQte[i] = TabQte[i + 1];
                }
                NbType--;
                System.out.println("***************         Type supprime         ****************");
            } else {
                System.out.println("*   Il existe des produits ayant ce type                     *");
            }
        } else {
            System.out.println("*   Ce type est inexistant                                   *");
        }
    }
//////application solid aussi
    public void afficher() {
        formatter.afficher(this);
    }
}
}
