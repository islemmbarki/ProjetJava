//SRP
import com.mycompany.projetjava.Produit;
import com.mycompany.projetjava.Type;

/**
 * Handles inventory management operations
 * Reason: Separates inventory logic from product data (SRP)
 */
public class ProductInventoryService {
    private final ProductValidator validator;

    public ProductInventoryService(ProductValidator validator) {
        this.validator = validator;
    }

    public void addProductToStock(Produit p, int nbTyp, Type[] tabType, int[] tabQte, Produit[][] stock) {
        if (!validator.isValid(p)) {
            throw new IllegalArgumentException("Invalid product");
        }

        int typeIndex = findTypeIndex(p, nbTyp, tabType);
        validateAddOperation(p, tabQte[typeIndex], stock[typeIndex]);

        addToStock(p, tabQte, stock, typeIndex);
    }

    private int findTypeIndex(Produit p, int nbTyp, Type[] tabType) {
        // ... implementation
    }

    private void validateAddOperation(Produit p, int quantity, Produit[] stockRow) {
        // ... validation logic
    }

    private void addToStock(Produit p, int[] quantities, Produit[][] stock, int typeIndex) {
        // ... add implementation
    }

    public void removeProductFromStock(Produit p, int[] quantities, Produit[][] stock, Type[] types, int typeCount) {
        // ... remove implementation
    }
}