public class DefaultProductFactory implements ProductFactory {
    @Override
    public Produit createProduct(int id, String name, Type type, MaDate date) {
        return new Produit(id, name, type, date);
    }
}
