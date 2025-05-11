package com.mycompany.projetjava.Statistic;

import com.mycompany.projetjava.*;
import com.mycompany.projetjava.product.Produit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class YearlyStatistic implements StatisticStrategy {


    @Override
    public void generateStatistics(int mois, int annee, Categorie[] TabCat, int NbCat) {
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
//                StatMois(i, annee, TabCat, NbCat);
        }

    }
}