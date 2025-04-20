import com.mycompany.projetjava.Produit;
import com.mycompany.projetjava.Type;
import com.mycompany.projetjava.MaDate;
public class DefaultProductFactory implements ProductFactory {
    @Override
    public Produit createProduct(int id, String name, Type type, MaDate expirationDate) {
        return new Produit(id, name, type, expirationDate);
    }
    
    @Override
    public Produit createDefaultProduct() {
        return new Produit();
    }
}
