import com.mycompany.projetjava.Categorie;
import com.mycompany.projetjava.Produit;

public class StockManager {
    public static void afficherStock(Categorie[] tabCat, int nbCat, Type[] tabType, int nbTyp, int[] tabQte, Produit[][] stock) {
        System.out.println("* Etat du stock: *");
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
}
