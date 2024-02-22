import java.io.Serializable;

// Abstract class representing a generic product
public abstract class Product implements Serializable {
    private String productID;         // Unique identifier for the product
    private String productName;       // Name of the product
    private int noAvailableItems;     // Number of available items in stock
    private double productPrice;       // Price of the product
    private String category;           // Category of the product (to be defined in subclasses)
    private String info;               // Additional information about the product (to be defined in subclasses)
    private String uniqueValue;        // Unique value associated with the product (to be defined in subclasses)
    private int quantity;              // Quantity of the product in the shopping cart

    // Constructor for initializing common attributes of a product
    public Product(String productID, String productName, int noAvailableItems, double productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.noAvailableItems = noAvailableItems;
        this.productPrice = productPrice;
    }

    // Default constructor
    public Product(){}

    // Abstract method to print product details (implementation in subclasses)
    public abstract void printProducts();

    // Getter and setter methods for various attributes

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getNoAvailableItems() {
        return noAvailableItems;
    }

    public void setNoAvailableItems(int noAvailableItems) {
        this.noAvailableItems = noAvailableItems;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getCategory(){
        return this.category;
    }

    public String getInfo(){
        return this.info;
    }

    public String getUniqueValue(){
        return this.uniqueValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
