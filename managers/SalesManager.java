package com.mycompany.projetjava.managers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.mycompany.projetjava.product.Produit;

public class SalesManager {
    public static void vendreProduit(Type[] types, int nbTypes, int[] quantities, Produit[][] stock, Scanner scanner) {
        int i, idType, iMin = 0;
        Produit min;
        MaDate dateVente = new MaDate();
        
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
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Trace.txt", true))) {
            // ... (code existant)
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans Trace.txt");
        }
    }
}