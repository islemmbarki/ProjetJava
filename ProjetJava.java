/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projetjava;
import java.util.Scanner;
//import static com.mycompany.projetjava.Categorie.AjouterCat;

import javax.naming.spi.ObjectFactory;

import com.mycompany.projetjava.product.Produit;
import com.mycompany.projetjava.product.Produit.ProductService;
import com.mycompany.projetjava.Statistic.MonthlyStatistic;
import com.mycompany.projetjava.managers.StatsManager;

/**
 *
 * @author 
 */
public class ProjetJava {
    public static void main(String[] args){

        // Initialize types using factory method
       TabCat[0] = ObjectFactory.createCategorie(1, "Conserve");
       TabType[0] = ObjectFactory.createType(1, "Tomate", TabCat[0]);
       Stock[0][0] = ObjectFactory.createProduit(1, "Sicam", TabType[0], new MaDate(5, 12, 2024));

       // Plus besoin de créer Categorie séparément (Principe du GRASP Creator)
       TabType[0] = new Type(1, "Tomate", 1, "Conserve"); // Crée sa Catégorie interne
       Stock[0][0] = new Produit(1, "Sicam", 1, "Tomate", 1, "Conserve", new MaDate(5, 12, 2024)); // Crée son Type interne


        // Initialize quantities
        int[] TabQte = new int[50];


       /** 
        // Avant
        Menu.afficherStock(TabCat, nbCat, TabType, nbTyp, TabQte, Stock);
        Menu.VendrePdt(TabType, NbType, TabQte, Stock);**/

        // Après
        StockManager.afficherStock(TabCat, nbCat, TabType, nbTyp, TabQte, Stock);
        SalesManager.vendreProduit(TabType, NbType, TabQte, Stock, scanner);
        MonthlyStatistic month = new MonthlyStatistic() ;
        StatsManager s = new StatsManager(month);
        s.process(4 , 2001 , TabType[0] , 12);


        
        
        /** 
        Categorie[] TabCat = new Categorie[20];
        int nbCat;
        Type[] TabType = new Type[50];
        int nbTyp;
        int[] TabQte = new int[50];
        Produit[][] Stock = new Produit[100][50];**/

        // Initialize categories
        TabCat[0] = new Categorie(1, "Conserve");
        TabCat[1] = new Categorie(2, "PLaitiers");
        nbCat = 2;

        // Initialize types
        TabType[0] = new Type(1, "Tomate", TabCat[0]);
        TabQte[0] = 0;
        TabType[1] = new Type(2, "Mais", TabCat[0]);
        TabQte[1] = 0;
        TabType[2] = new Type(3, "Lait", TabCat[1]);
        TabQte[2] = 0;
        nbTyp = 3;
        
        // Initialize stock
        Stock[0][0] = new Produit(1, "Sicam", TabType[0],new MaDate(5, 12, 2024));
        TabQte[0]++;
        Stock[1][0] = new Produit(2, "Sicam", TabType[0], new MaDate(24, 4, 2023));
        TabQte[0]++;
        Stock[0][2] = new Produit(1, "Vitalait", TabType[2], new MaDate(24, 10, 2024));
        TabQte[2]++;

        // menu
        Scanner scanner = new Scanner(System.in);
        Type T = new Type();
        Produit p = new Produit();
        int c1, c2=0, c3=0, mois, annee;

                System.out.println("**********************");
        System.out.println("*******      Bienvenue      ********");
        System.out.println("**********************");
        
        do {
            c1 = Menu.displayMenu(scanner);
            switch (c1) {
                case 1 -> {
                    do {
                        c2 = Menu.displayMenuGestion(scanner);
                        switch (c2) {
                            case 1 -> {
                                do {
                                    c3 = Menu.displayGestionCategories(scanner);
                                    switch (c3) {
                                        case 1 -> {
                                            Categorie c=new Categorie(2,"rrr");
                                            Categorie.AjouterCat(nbCat,c,TabCat);
                                        }
                                        case 2 -> Categorie.supprimerCat(TabCat,nbCat,TabType,nbTyp,2);
                                        case 3 -> {
                                        }
                                        case 4 -> {
                                        }
                                        default -> System.out.println("*******      Au revoir!     ********");
                                    }
                                } while (c3 != 0 && c3 != 3 && c3 != 4);
                            }
                            case 2 -> {
                                do {
                                    c3 = Menu.displayGestionTypes(scanner);
                                    switch (c3) {
                                        case 1 -> Type.AjouterType(T,TabType, nbTyp, TabCat, nbCat, TabQte,scanner);
                                        case 2 -> Type.SupprimerType(TabType, nbTyp, TabQte,scanner);
                                        case 3 -> {
                                        }
                                        case 4 -> {
                                        }
                                        default -> System.out.println("*******      Au revoir!     ********");
                                    }
                                } while (c3 != 0 && c3 != 3 && c3 != 4);
                            }
                            case 3 -> {
                                do {
                                    c3 = Menu.displayGestionProduits(scanner);
                                    switch (c3) {
                                        case 1:
                                            Produit.initPdt(p, nbTyp, TabType, TabQte);
                                            Produit.ajouterPdt(p,nbTyp,TabType,TabQte,Stock);
                                            break;
                                        case 2:
                                            Produit.initPdt(p, nbTyp, TabType, TabQte);
                                            Produit.SupprimerPdt(Stock,TabQte,p,TabType,nbTyp);
                                            break;
                                        case 3:
                                            break;
                                        case 4:
                                            break;
                                        default:
                                            System.out.println("*******      Au revoir!     ********");
                                            break;
                                    }
                                } while (c3 != 0 && c3 != 3 && c3 != 4);
                            }
                            case 4 -> {
                                Menu.afficherStock(TabCat, nbCat, TabType, nbTyp, TabQte, Stock);
                            }
                            case 5 -> {
                            }
                            default -> System.out.println("*******      Au revoir!     ********");
                        }
                    } while (c2 != 0 && c2 != 5 && c3 != 0 && c3 != 4);
                 }
                case 2 -> {
                    do {
                        c2 = Menu.displayMenuVenteStat(scanner);
                        switch (c2) {
                            case 1 -> Menu.VendrePdt(TabType, nbTyp, TabQte, Stock);
                            case 2 -> {
                                do {
                                    System.out.println("*  Choisir le mois                                           *");
                                    System.out.println("01-Janvier\t02-Fevrier\t03-Mars\t04-Avril\t05-Mai\t06-Juin");
                                    System.out.println("07-Juillet\t08-Aout\t09-Septembre\t10-Octobre\t11-Novembre\t12-Decembre");
                                    mois = scanner.nextInt();
                                } while (mois < 1 || mois > 12);
                                do {
                                    System.out.println("* Choisir l'annee                                            * ");
                                    annee = scanner.nextInt();
                                } while (annee < 1980 || annee > 2080);
                                Menu.StatMois(mois, annee, TabCat, nbCat);
                            }
                            case 3 -> {
                                do {
                                    System.out.println("* Choisir l'annee                                            * ");
                                    annee = scanner.nextInt();
                                } while (annee < 1980 || annee > 2080);
                                Menu.StatAnnee(annee, TabCat, nbCat);
                            }
                            case 4 -> {
                            }
                            default -> System.out.println("*******      Au revoir!     ********");
                        }
                    } while (c2 != 0 && c2 != 4);
                 }
                default -> System.out.println("*******      Au revoir!     ********");
            }
        } while (c1 != 0 && c2 != 0 && c3 != 0);
        
        scanner.close();
    }
    
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

