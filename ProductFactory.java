import com.mycompany.projetjava.product.Produit;
import com.mycompany.projetjava.Type;
import com.mycompany.projetjava.MaDate;

public interface ProductFactory {
    Produit createProduct(int id, String name, Type type, MaDate expirationDate);
    Produit createDefaultProduct();
}