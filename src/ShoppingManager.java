import java.io.IOException;

public interface ShoppingManager {
    public  void addProduct();
    public  void deleteProduct();
    public void printProducts();
    public void saveToFile() throws IOException;
    public void readFromFile();
}
