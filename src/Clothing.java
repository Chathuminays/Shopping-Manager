import java.io.Serializable;

// Subclass representing clothing products, extends the Product class
public class Clothing extends Product implements Serializable {

    private String clothSize;       // Size of the clothing
    private String clothColor;      // Color of the clothing

    // Constant representing the category of the clothing product
    private final String category = "Clothing";

    // Constructor to initialize attributes of the clothing product
    public Clothing(String productID, String productName, int noAvailableItems, double productPrice, String clothSize, String clothColor) {
        // Call the constructor of the superclass (Product) to initialize common attributes
        super(productID, productName, noAvailableItems, productPrice);
        this.clothSize = clothSize;
        this.clothColor = clothColor;
    }

    // Default constructor
    public Clothing(){}

    // Getter and setter methods for specific attributes of clothing products

    public String getClothSize() {
        return clothSize;
    }

    public void setClothSize(String clothSize) {
        this.clothSize = clothSize;
    }

    public String getClothColor() {
        return clothColor;
    }

    public void setClothColor(String clothColor) {
        this.clothColor = clothColor;
    }

    // Override the getCategory method to provide the category specific to clothing
    @Override
    public String getCategory() {
        return category;
    }

    // Override the getInfo method to provide additional information specific to clothing
    @Override
    public String getInfo(){
        return getClothSize() + ", " + getClothColor();
    }

    // Override the getUniqueValue method to provide unique values specific to clothing
    @Override
    public String getUniqueValue(){
        return "Size: " + getClothSize() + "\n"
                + "Colour: " + getClothColor() + "\n";
    }

    // Override the printProducts method to display details of the clothing product
    @Override
    public void printProducts(){
        System.out.println("Product ID : " + getProductID());
        System.out.println("Product Name : " + getProductName());
        System.out.println("Category : " + getCategory());
        System.out.println("Quantity : " + getNoAvailableItems());
        System.out.println("Price : " + getProductPrice());
        System.out.println("Size : " + getClothSize());
        System.out.println("Color : " + getClothColor());
        System.out.println("\n");
    }
}
