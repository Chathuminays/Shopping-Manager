import java.io.Serializable;

// Subclass representing electronic products, extends the Product class
public class Electronics extends Product implements Serializable {

    private String productBrand;          // Brand name of the electronic product
    private int warrantyTimePeriod;       // Warranty time period in weeks

    // Constant representing the category of the electronic product
    private final String category = "Electronics";

    // Constructor to initialize attributes of the electronic product
    public Electronics(String productID, String productName, int noAvailableItems, double productPrice, String productBrand, int warrantyTimePeriod) {
        // Call the constructor of the superclass (Product) to initialize common attributes
        super(productID, productName, noAvailableItems, productPrice);
        this.productBrand = productBrand;
        this.warrantyTimePeriod = warrantyTimePeriod;
    }

    // Default constructor
    public Electronics(){}

    // Getter and setter methods for specific attributes of electronic products

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public int getWarrantyTimePeriod() {
        return warrantyTimePeriod;
    }

    public void setWarrantyTimePeriod(int warrantyTimePeriod) {
        this.warrantyTimePeriod = warrantyTimePeriod;
    }

    // Override the getCategory method to provide the category specific to electronics
    @Override
    public String getCategory() {
        return category;
    }

    // Override the getInfo method to provide additional information specific to electronics
    @Override
    public String getInfo(){
        return getProductBrand() + ", " + getWarrantyTimePeriod() + " weeks warranty";
    }

    // Override the getUniqueValue method to provide unique values specific to electronics
    @Override
    public String getUniqueValue(){
        return "Brand: " + getProductBrand() + "\n"
                + "Warranty Time Period: " + getWarrantyTimePeriod() + " weeks\n";
    }

    // Override the printProducts method to display details of the electronic product
    @Override
    public void printProducts(){
        System.out.println("Product ID : " + getProductID());
        System.out.println("Product Name : " + getProductName());
        System.out.println("Category : " + getCategory());
        System.out.println("Quantity : " + getNoAvailableItems());
        System.out.println("Price : " + getProductPrice());
        System.out.println("Brand Name : " + getProductBrand());
        System.out.println("Warranty Time Period : " + getWarrantyTimePeriod() + " weeks warranty");
        System.out.println("\n");
    }
}
