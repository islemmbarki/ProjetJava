/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.projetjava;
import java.util.Scanner;

public class Produit {
    int id ;
    String  Nom;
    Type Typ ;
    MaDate Date_expiration ;

       // Class invariant
    private boolean invariant() {
        return id >= 0 && 
               nom != null && !nom.trim().isEmpty() && 
               typ != null && 
               date_expiration != null;
    }

  
    public Produit(int id, String nom, Type typ, MaDate date_expiration) {
        if (id < 0 || nom == null || nom.trim().isEmpty() || typ == null || date_expiration == null) {
            throw new IllegalArgumentException("Invalid product parameters");
        }
        this.id = id;
        this.nom = nom;
        this.typ = typ;
        this.date_expiration = date_expiration;
        assert invariant();
    }

    public Produit() {
        this(0, "New Product", new Type(), new MaDate());
    }
/** 
    // Constructor is now private to enforce factory usage
    public Produit(int id, String nom, Type typ, MaDate dateExpiration) {
        this.id = id;
        this.nom = nom;
        this.typ = typ;
        this.dateExpiration = dateExpiration;
        assert invariant();
    }**/

    // Default constructor remains for compatibility
   /** public Produit() {
        this(0, "", new Type(), new MaDate());
    }**/



    // Getters and setters with invariant checks
    public void setId(int id) {
        if (id < 0) throw new IllegalArgumentException("ID cannot be negative");
        this.id = id;
        assert invariant();
    }
 

    // New class for product operations to follow SRP
    class ProductService {
    private ProductFactory productFactory;
    
    public ProductService(ProductFactory factory) {
        this.productFactory = factory;
    }

    public Produit createNewProduct(int id, String name, Type type, MaDate date) {
        return productFactory.createProduct(id, name, type, date);
    }
    

    // ... other getters/setters with similar validation

    // ==============================================
    // NOTE: The following methods have been MOVED to new classes:
    // - initPdt() moved to ProductInitializerService
    // - ajouterPdt() moved to ProductInventoryService
    // - SupprimerPdt() moved to ProductInventoryService
    // ==============================================
    
    
    /**public int getId() {
        return id;
    }

    public String getNom() {
        return Nom;
    }

    public Type getTyp() {
        return Typ;
    }

    public MaDate getDate_expiration() {
        return Date_expiration;
    }**/

   // public void setId(int id) {
    //    this.id = id;
    //}

    //public void setNom(String Nom) {
      //  this.Nom = Nom;
    //}

   // public void setTyp(Type Typ) {
      //  this.Typ = Typ;
    //}

   // public void setDate_expiration(MaDate Date_expiration) {
       // this.Date_expiration = Date_expiration;
    //}
   // public Produit(){
    //    id = 0;
     //   Nom = "";
    //}
    
    
    
    /*public Produit(int i ,String n,Type t,MaDate m){
        id = i;
        Nom = n;
        Typ = t;
        Date_expiration = m;
    }*/


  public static void initPdt(Produit produit, int nbTyp, Type[] tabType, int[] indice) {
         Scanner scanner = new Scanner(System.in);

         System.out.print("\nDonner l'id du produit: ");
         produit.setId(scanner.nextInt());
         scanner.nextLine(); // Consomme la nouvelle ligne

         System.out.print("Donner le nom du produit: ");
         produit.setNom(scanner.nextLine());

         System.out.println("Remplir la date d'expiration du produit:");
         MaDate.InitDate(produit.Date_expiration,scanner);

         for (int i = 0; i < nbTyp; i++) {
             System.out.printf("%d: %s\t", i, tabType[i].getNomType());
         }

         System.out.print("\nDonner l'indice du type auquel appartient le produit: ");
         indice[0] = scanner.nextInt();

         produit.getTyp().setNomType(tabType[indice[0]].getNomType());
         produit.getTyp().setIdType(tabType[indice[0]].getIdType());
         produit.getTyp().getCat().setIdCat(tabType[indice[0]].getCat().getIdCat());
        produit.getTyp().getCat().setNomCat(tabType[indice[0]].getCat().getNomCat());
    }


////application grasp low coupling 
/* *
public static void initPdt(Produit produit, int nbTyp, Type[] tabType, int[] indice, Scanner scanner) {
    System.out.print("\nDonner l'id du produit: ");
    produit.setId(scanner.nextInt());
    scanner.nextLine(); // Consomme la nouvelle ligne

    System.out.print("Donner le nom du produit: ");
    produit.setNom(scanner.nextLine());

    System.out.println("Remplir la date d'expiration du produit:");
    DateService.initExpirationDate(produit.Date_expiration, scanner);  // Utilisation du service

    for (int i = 0; i < nbTyp; i++) {
        System.out.printf("%d: %s\t", i, tabType[i].getNomType());
    }

    System.out.print("\nDonner l'indice du type auquel appartient le produit: ");
    indice[0] = scanner.nextInt();

    TypeService.setTypeForProduit(produit, tabType, indice[0]);  // Utilisation du service
}**/





   public static void ajouterPdt(Produit p, int nbTyp, Type[] tabType, int[] tabQte, Produit[][] stock) {
        int ind = -5;
        for (int i = 0; i < nbTyp; ++i) {
            if (tabType[i].getIdType() == p.getTyp().getIdType()) {
                ind = i;
                break;
            }
        }

        if (ind != -5) {
            if (tabQte[ind] < 100) {
                boolean produitExiste = false;
                for (int i = 0; i < tabQte[ind]; ++i) {
                    if (stock[i][ind].getId() == p.getId()) {
                        produitExiste = true;
                        break;
                    }
                }

                if (!produitExiste) {
                    int j = tabQte[ind];
                    stock[j][ind] = new Produit();
                    stock[j][ind].setId(p.getId());
                    stock[j][ind].setDate_expiration(p.getDate_expiration());
                    stock[j][ind].setNom(p.getNom());
                    stock[j][ind].setTyp(new Type());
                    stock[j][ind].getTyp().setIdType(p.getTyp().getIdType());
                    stock[j][ind].getTyp().setNomType(p.getTyp().getNomType());
                    stock[j][ind].getTyp().setCat(new Categorie());
                    stock[j][ind].getTyp().getCat().setIdCat(p.getTyp().getCat().getIdCat());
                    stock[j][ind].getTyp().getCat().setNomCat(p.getTyp().getCat().getNomCat());
                    tabQte[ind]++;
                    System.out.println("Produit ajouté avec succès");
                } else {
                    System.out.println("Le produit existe déjà dans la matrice Stock");
                }
            } else {
                System.out.println("SUPPRESSION IMPOSSIBLE !! La quantité est inférieure à 100");
            }
        } else {
            System.out.println("Le type du produit n'existe pas dans TabType");
        }
    }




 /*public static void supprimerPdt(int idProduit, int idType, int nbTyp, Type[] tabType, int[] tabQte, Produit[][] stock) {
        int indiceType = -1;
        for (int i = 0; i < nbTyp; ++i) {
            if (tabType[i].getIdType() == idType) {
                indiceType = i;
                break;
            }
        }

        if (indiceType != -1) {
            if (tabQte[indiceType] > 10) {
                int indiceProduit = -1;
                for (int i = 0; i < tabQte[indiceType]; ++i) {
                    if (stock[i][indiceType].getId() == idProduit) {
                        indiceProduit = i;
                        break;
                    }
                }

                if (indiceProduit != -1) {
                    for (int i = indiceProduit; i < tabQte[indiceType] - 1; ++i) {
                        stock[i][indiceType] = stock[i + 1][indiceType];
                    }

                    tabQte[indiceType]--;
                    System.out.println("SUPPRESSION REUSSIE !");
                } else {
                    System.out.println("SUPPRESSION IMPOSSIBLE !! Le produit n'existe pas dans la matrice Stock.");
                }
            } else {
                System.out.println("SUPPRESSION IMPOSSIBLE !! La quantité est inférieure à 10.");
            }
        } else {
            System.out.println("SUPPRESSION IMPOSSIBLE !! Le type du produit n'existe pas dans TabType.");
        }
    }
    public static int prodExiste(Produit[][] stock, int c, int qte, Produit prod) {
        int l = 0;
        while (l < qte && stock[l][c].getId() != prod.getId()) {
            l++;
        }
        return (l == qte) ? 0 : 1;
    }
*/
  

public static void SupprimerPdt(Produit[][] stock, int[] tabQte, Produit pdt, Type[] tabType, int nbType) {
        int i = 0, j = 0;
        i = Type.TypeExiste(tabType, nbType, pdt.Typ);

        if (i != -1) {
            if (tabQte[i] >= 10) {
                while (j < tabQte[i] && stock[j][i].id != pdt.id) {
                    j++;
                }
                if (j != tabQte[i]) {
                    for (; j < tabQte[i] - 1; j++) {
                        stock[j][i] = stock[j + 1][i];
                    }
                    tabQte[i]--;
                    System.out.println("***********       Produit supprime        **************");
                } else {
                    System.out.println("***********      Produit inexistant       **************");
                }
            } else {
                System.out.println("*   Le nb de produit minimum est atteint                    *");
            }
        } else {
            System.out.println("*   Produit errone                                           *");
        }
    }
}
}