/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetjava;
import java.util.Scanner;

import javax.naming.spi.ObjectFactory;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author 
 */
public class Menu {
    public static void afficherStock(Categorie[] tabCat, int nbCat, Type[] tabType, int nbTyp, int[] tabQte, Produit[][] stock) {
        System.out.println();
        System.out.println("* Etat du stock:                                             *");
        System.out.println("*                                                            *");
        System.out.println("* Categorie         Type      Qte     id-Pdt      date_exp   *");
        System.out.println("* ---------------------------------------------------------- *");

        for (int i = 0; i < nbCat; i++) {
            System.out.printf(" %-10s\t", tabCat[i].nomCat);
            for (int j = 0; j < nbTyp; j++) {
                if (tabType[j].cat.idCat == tabCat[i].idCat) {
                    System.out.printf("%-10s\t%2d\t", tabType[j].nomType, tabQte[j]);
                    for (int k = 0; k < tabQte[j]; k++) {
                        System.out.printf("%2d\t%2d/%2d/%4d\n", stock[k][j].getId(), stock[k][j].getDate_expiration().getJJ(), stock[k][j].getDate_expiration().getMM(), stock[k][j].getDate_expiration().getAA());
                        System.out.print("                                        ");
                    }
                    System.out.println("\n                ");
                }
            }
            System.out.println();
        }
        System.out.println("* ---------------------------------------------------------- *");
    }
         public static int displayGestionCategories(Scanner scanner) {
        int c;
        System.out.println("* Gestion du Stock/Gestion des categories                    *");
        System.out.println("*  1-Ajout d'une nouvelle categorie                          *");
        System.out.println("*  2-Suppression d'une categorie                             *");
        System.out.println("*  3-Retour menu Gestion du Stock                            *");
        System.out.println("*  4-Retour menu principal                                   *");
        do {
            System.out.print("* >> Tapez votre choix:                                      * ");
            c = scanner.nextInt();
        } while (c != 1 && c != 2 && c != 3 && c != 4 && c != 0);
        return c;
    }

    public static int displayGestionTypes(Scanner scanner) {
        int c;
        System.out.println("* Gestion du Stock/Gestion des types                         *");
        System.out.println("*  1-Ajout d'un nouveau type                                 *");
        System.out.println("*  2-Suppression d'un type                                   *");
        System.out.println("*  3-Retour menu Gestion du Stock                            *");
        System.out.println("*  4-Retour menu principal                                   *");
        do {
            System.out.print("* >> Tapez votre choix:                                      * ");
            c = scanner.nextInt();
        } while (c != 1 && c != 2 && c != 3 && c != 4 && c != 0);
        return c;
    }

    public static int displayGestionProduits(Scanner scanner) {
        int c;
        System.out.println("* Gestion du Stock/Gestion des Produits                      *");
        System.out.println("*  1-Ajout d'un nouveau produit                              *");
        System.out.println("*  2-Suppression d'un produit                                *");
        System.out.println("*  3-Retour menu Gestion du Stock                            *");
        System.out.println("*  4-Retour menu principal                                   *");
        do {
            System.out.print("* >> Tapez votre choix:                                      * ");
            c = scanner.nextInt();
        } while (c != 1 && c != 2 && c != 3 && c != 4 && c != 0);
        return c;
    }

    public static int displayMenuGestion(Scanner scanner) {
        int c;
        System.out.println("* Gestion du Stock                                           *");
        System.out.println("*  1- Gestion des categories                                 *");
        System.out.println("*  2- Gestion des types                                      *");
        System.out.println("*  3- Gestion des produits                                   *");
        System.out.println("*  4- Affichage du Stock                                     *");
        System.out.println("*  5- Retour au menu principal                               *");
        do {
            System.out.print("* >> Tapez votre choix:                                      * ");
            c = scanner.nextInt();
        } while (c != 1 && c != 2 && c != 3 && c != 4 && c != 5 && c != 0);
        return c;
    }

    public static int displayMenuVenteStat(Scanner scanner) {
        int c;
        System.out.println("* Vente et Statistiques                                      *");
        System.out.println("*  1-Vendre un produit                                       *");
        System.out.println("*  2-Statistiques mois                                       *");
        System.out.println("*  3-Statistiques annee                                      *");
        System.out.println("*  4-Retour au menu principal                                *");
        do {
            System.out.print("* >> Tapez votre choix:                                      * ");
            c = scanner.nextInt();
        } while (c != 1 && c != 2 && c != 3 && c != 4 && c != 0);
        return c;
    }

    public static int displayMenu(Scanner scanner) {
        int c;
        System.out.println("* Veuillez choisir une option:                               *");
        System.out.println("*  1- Gestion du Stock                                       *");
        System.out.println("*  2- Vente et Statistiques                                  *");
        do {
            System.out.print("* >> Tapez votre choix:                                      * ");
            c = scanner.nextInt();
        } while (c != 1 && c != 2 && c != 0);
        return c;
    }

    public static void VendrePdt(Type[] TabType, int NbType, int[] TabQte, Produit[][] Stock) {
        Scanner scanner = new Scanner(System.in);
        int i, j, idType, iMin = 0;
        Produit min;
        MaDate DateVente = new MaDate();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Trace.txt", true))) {
            System.out.println("* Quel type de produit voudriez-vous vendre?                 *");
            for (i = 0; i < NbType; i++) {
                System.out.printf("%d-%s\t", TabType[i].idType, TabType[i].nomType);
            }
            System.out.println();
            
            idType = scanner.nextInt();
            
            i = 0;
            while (i < NbType && TabType[i].idType != idType) {
                i++;
            }
            
            if (i == NbType) {
                System.out.println("Type de produit non trouvé");
                return;
            }
            
            if (TabQte[i] == 0) {
                System.out.println("Aucun produit disponible pour ce type");
                return;
            }
            
            //min = Stock[0][i];

            //Factory Method Pattern
            min = ObjectFactory.createProduit(
            Stock[0][i].getId(),
            Stock[0][i].getNom(),
            Stock[0][i].getTyp(),
            Stock[0][i].getDate_expiration()
);
            
            for (j = 1; j < TabQte[i]; j++) {
                if (Stock[j][i].getDate_expiration().getAA() < min.getDate_expiration().getAA()) {
                    min = Stock[j][i];
                    iMin = j;
                } else if (Stock[j][i].getDate_expiration().getAA() == min.getDate_expiration().getAA()) {
                    if (Stock[j][i].getDate_expiration().getMM() < min.getDate_expiration().getMM()) {
                        min = Stock[j][i];
                        iMin = j;
                    } else if (Stock[j][i].getDate_expiration().getMM() == min.getDate_expiration().getMM()) {
                        if (Stock[j][i].getDate_expiration().getJJ() < min.getDate_expiration().getJJ()) {
                            min = Stock[j][i];
                            iMin = j;
                        }
                    }
                }
            }
            
            System.out.println("*  Date de vente:                                            *");
            MaDate.InitDate(DateVente,scanner);
            writer.write(String.format("%d\t%s\t%d\t%s\t%d\t%s\t%d/%d/%d\n", 
                    min.getId(), min.Nom, min.getTyp().idType, min.getTyp().nomType, min.getTyp().cat.idCat, min.getTyp().cat.nomCat, DateVente.getJJ(), DateVente.getMM(), DateVente.getAA()));
            
            for (j = iMin; j < TabQte[i] - 1; j++) {
                Stock[j][i] = Stock[j + 1][i];
            }
            
            TabQte[i]--;
            System.out.println("*************        Vente effectuee       ****************");
        } catch (IOException e) {
            System.out.println("Erreur lors de l'ouverture du fichier Trace.txt");
        }
    }
        
    public static void StatMois(int mois, int annee, Categorie[] TabCat, int NbCat) {
        int i, j, nvTotal = 0;
        int[] nvCat = new int[20];
        Produit p = new Produit();

        for (i = 0; i < NbCat; i++) {
            nvCat[i] = 0;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("Trace.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\t|/");
                p.setId(Integer.parseInt(parts[0]));
                p.Nom = parts[1];
                p.Typ = new Type();
                p.Typ.idType = Integer.parseInt(parts[2]);
                p.Typ.nomType = parts[3];
                p.Typ.cat = new Categorie();
                p.Typ.cat.idCat = Integer.parseInt(parts[4]);
                p.Typ.cat.nomCat = parts[5];
                p.Date_expiration = new MaDate();
                p.Date_expiration.setJJ(Integer.parseInt(parts[6]));
                p.Date_expiration.setMM(Integer.parseInt(parts[7]));
                p.Date_expiration.setAA(Integer.parseInt(parts[8]));

                if (p.Date_expiration.getMM() == mois && p.Date_expiration.getAA() == annee) {
                    nvTotal++;
                    j = 0;
                    while (j < NbCat && TabCat[j].idCat != p.Typ.cat.idCat) {
                        j++;
                    }
                    if (j < NbCat) {
                        nvCat[j]++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de l'ouverture du fichier Trace.txt");
        }

        System.out.printf("*  Nombre de ventes total: %d                                  *\n", nvTotal);
        for (i = 0; i < NbCat; i++) {
            System.out.printf("*  Nombre de ventes pour la categorie %s: %d                   *\n", TabCat[i].nomCat, nvCat[i]);
        }
    }

    
        public static void StatAnnee(int annee, Categorie[] TabCat, int NbCat) {
        int i, j, nvTotal = 0;
        int[] nvCat = new int[20];
        Produit p;

        for (i = 0; i < NbCat; i++) {
            nvCat[i] = 0;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("Trace.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\t|/");
                p = new Produit();
                p.id = Integer.parseInt(parts[0]);
                p.Nom = parts[1];
                p.Typ = new Type();
                p.Typ.idType = Integer.parseInt(parts[2]);
                p.Typ.nomType = parts[3];
                p.Typ.cat = new Categorie();
                p.Typ.cat.idCat = Integer.parseInt(parts[4]);
                p.Typ.cat.nomCat = parts[5];
                p.Date_expiration = new MaDate();
                p.Date_expiration.setJJ(Integer.parseInt(parts[6]));
                p.Date_expiration.setMM(Integer.parseInt(parts[7]));
                p.Date_expiration.setAA(Integer.parseInt(parts[8]));

                if (p.Date_expiration.getAA() == annee) {
                    nvTotal++;
                    j = 0;
                    while (j < NbCat && TabCat[j].idCat != p.Typ.cat.idCat) {
                        j++;
                    }
                    if (j < NbCat) {
                        nvCat[j]++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de l'ouverture du fichier Trace.txt");
        }

        System.out.printf("*  Nombre de ventes total: %d                                  *\n", nvTotal);
        for (i = 1; i < NbCat; i++) {
            System.out.printf("*  Nombre de ventes pour la categorie %s: %d                   *\n", TabCat[i].nomCat, nvCat[i]);
        }

        for (i = 0; i < 13; i++) {
            System.out.println("**************************************************************");
            System.out.printf("*      Statistiques du mois %2d                               *\n", i);
            StatMois(i, annee, TabCat, NbCat);
        }
    }
}
