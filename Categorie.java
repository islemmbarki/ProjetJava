/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.projetjava;
import java.lang.invoke.ClassSpecializer.Factory;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 21697
 */
public class Categorie {
    public int idCat;
    public String nomCat;

     // Class invariant: ID must be positive and name not empty
     private boolean invariant() {
        return idCat >= 0 && nomCat != null && !nomCat.trim().isEmpty();
    }

    //Implementing Creator Pattern (GRASP)
    public Type createType(String typeName) {
        return new Type(generateTypeId(), typeName, this);
    }
    
    private int generateTypeId() {
        return idCat;
        
    }
    
    /**public Categorie(int idCat, String nomCat) {
        this.idCat = idCat;
        this.nomCat = nomCat;
    }
    public Categorie() {
        this.idCat = 0;
        this.nomCat = ""; 
    }**/

    public Categorie(int idCat, String nomCat) {
        if (idCat < 0 || nomCat == null || nomCat.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid category parameters");
        }
        this.idCat = idCat;
        this.nomCat = nomCat;
        assert invariant();
    }

    public Categorie() {
        this(0, "Uncategorized");
    }

    // Factory method
    public static Categorie createCategory(int id, String name) {
        return new Categorie(id, name);
    }


    public int getIdCat() {
        return idCat;
    }

    public String getNomCat() {
        return nomCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public void setNomCat(String nomCat) {
        this.nomCat = nomCat;
    }
    
    public Categorie initCat(){
        Scanner s=new Scanner(System.in);
        System.out.println("Donner le numero de la Categorie");
        int n=s.nextInt();
        System.out.println("Donner le NOM de la Categorie");
        String st=s.nextLine();
        Categorie c=new Categorie(n,st);
        return c;
        
        

        
    }
     public static void AjouterCat(int nbCat,Categorie c, Categorie[] TabCat) {
        // Vérifie si NbCat est inférieur à 20
        if (nbCat >= 20) {
            System.out.println("Nombre maximum de catégories atteint.");
        }

        // Vérifie si la nouvelle catégorie existe déjà dans TabCat
        for (int i = 0; i < nbCat; i++) {
            if (TabCat[i].equals(c)) {
                System.out.println("La catégorie existe déjà.");
            }
        }

        // Ajoute la nouvelle catégorie à TabCat
        TabCat[nbCat]=c;
        nbCat++;
        System.out.println("Catégorie ajoutée avec succès.");
    }

     public static void  supprimerCat(Categorie TabCat[],int nbCat,Type TabType[],int nbTyp,int idCat){
        int test=1;
        int x = 0,i;
        for(i=0;i<nbTyp;i++){
                if(TabType[i].cat.idCat==idCat){
                    test=0;
                }


        }
        if(test==0){
            System.out.println("SUPPRESSION IMPOSSIBLE !! Il Existe des types de cette categorie dans la table des types");
        }
        else{
            for(i=0;i<nbCat;i++){
                if(TabCat[i].idCat==idCat){
                   x=i;
                }
            }
            for(int j=x;j<nbCat;j++){
                TabCat[j]=TabCat[j+1];
            }
            (nbCat)--;
            System.out.println("SUPPRESSION REUSSIE !\n");


        }

    }
    
}

