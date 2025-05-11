package com.mycompany.projetjava.services;//SRP
import com.mycompany.projetjava.product.Produit;
import com.mycompany.projetjava.Type;

import java.util.Scanner;

/**
 * Handles product initialization logic
 * Reason: Separates initialization from product data (SRP)
 */
public class ProductInitializerService {
    private final DateService dateService;
    private final TypeService typeService;

    public ProductInitializerService(DateService dateService, TypeService typeService) {
        this.dateService = dateService;
        this.typeService = typeService;
    }

    public void initializeProduct(Produit produit, int nbTyp, Type[] tabType, int[] indice, Scanner scanner) {
        System.out.print("\nEnter product ID: ");
        produit.setId(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Enter product name: ");
        produit.setNom(scanner.nextLine());

        dateService.initExpirationDate(produit.getDateExpiration(), scanner);
        typeService.setTypeForProduit(produit, tabType, indice[0]);
    }
}