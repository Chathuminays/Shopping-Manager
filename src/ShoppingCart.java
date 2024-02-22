import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

// Represents a shopping cart for the user
public class ShoppingCart {

    private ArrayList<Product> cartProducts;  // List of products in the shopping cart
    private User user;  // The user associated with the shopping cart
    private static int electricItemCount;  // Counter for the number of electronics items in the cart
    private static int clothingItemCount;  // Counter for the number of clothing items in the cart

    // Constructor to initialize the shopping cart with a user
    public ShoppingCart(User user) {
        this.user = user;
        this.cartProducts = new ArrayList<>();
        electricItemCount = 0;
        clothingItemCount = 0;
    }

    // Getter method to retrieve the user associated with the shopping cart
    public User getUser() {
        return user;
    }

    // Getter method to retrieve the count of electronics items in the cart
    public static int getElectricItemCount() {
        return electricItemCount;
    }

    // Getter method to retrieve the count of clothing items in the cart
    public static int getClothingItemCount() {
        return clothingItemCount;
    }

    // Method to add a product to the shopping cart
    public void addToCart(Product product) {

        // Increment the item count based on the product category
        if (product.getCategory().equals("Electronics")) {
            electricItemCount++;
        } else if (product.getCategory().equals("Clothing")) {
            clothingItemCount++;
        }

        boolean productExists = false;

        // Check if the product already exists in the cart
        for (Product cartProduct : cartProducts) {
            if (cartProduct.getProductID().equals(product.getProductID())) {
                cartProduct.setQuantity(cartProduct.getQuantity() + 1);
                productExists = true;
                break;
            }
        }

        // If the product does not exist, add it to the cart with a quantity of 1
        if (!productExists) {
            product.setQuantity(1);
            cartProducts.add(product);
        }
    }

    // Inner class representing the shopping cart frame
    public static class ShoppingCartFrame extends JFrame {

        private final DefaultTableModel tableModel;
        private final JLabel totalLabel;
        private final JLabel firstPurchaseDiscountLabel;
        private final JLabel categoryDiscountLabel;
        private final JLabel finalTotalLabel;

        // Constructor to initialize the shopping cart frame
        public ShoppingCartFrame(ShoppingCart shoppingCart) {
            setTitle("Shopping Cart");
            setSize(600, 450);

            // Create the table and set properties
            tableModel = new DefaultTableModel(new Object[]{"Product", "Quantity", "Total Price"}, 0);
            JTable table = new JTable(tableModel);
            int rowHeight = 70;
            table.setRowHeight(rowHeight);

            // Create scroll pane and set table properties
            JScrollPane scrollPane = new JScrollPane(table);
            table.setPreferredScrollableViewportSize(new Dimension(500, 150));
            table.setGridColor(Color.black);

            // Create tablePanel and add scrollPane to it
            JPanel tablePanel = new JPanel(new FlowLayout());
            tablePanel.setBackground(Color.ORANGE);
            tablePanel.add(scrollPane);

            // Add tablePanel to the BorderLayout.NORTH position
            add(tablePanel, BorderLayout.NORTH);

            // Create infoPanel for labels and set properties
            JPanel infoPanel = new JPanel(new FlowLayout());
            JPanel infoPanel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            infoPanel1.setBackground(Color.ORANGE);
            JPanel infoPanel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            infoPanel2.setBackground(Color.ORANGE);
            JPanel infoPanel3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            infoPanel3.setBackground(Color.ORANGE);
            JPanel infoPanel4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            infoPanel4.setBackground(Color.ORANGE);
            infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 80));
            infoPanel.setBackground(Color.ORANGE);

            // Create labels and add them to infoPanel
            totalLabel = new JLabel();
            firstPurchaseDiscountLabel = new JLabel();
            categoryDiscountLabel = new JLabel();
            finalTotalLabel = new JLabel();

            infoPanel.add(new JLabel());
            infoPanel1.add(totalLabel);
            infoPanel.add(new JLabel());
            infoPanel2.add(firstPurchaseDiscountLabel);
            infoPanel.add(new JLabel());
            infoPanel3.add(categoryDiscountLabel);
            infoPanel.add(new JLabel());
            infoPanel4.add(finalTotalLabel);

            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

            infoPanel.add(infoPanel1);
            infoPanel.add(infoPanel2);
            infoPanel.add(infoPanel3);
            infoPanel.add(infoPanel4);

            // Add infoPanel to BorderLayout.CENTER position
            add(infoPanel, BorderLayout.CENTER);

            // Update table and labels
            updateTable(shoppingCart.getCartProducts());
            updateTotalLabels(shoppingCart);

            setVisible(true);
        }

        // Method to update the table with the cart products
        public void updateTable(ArrayList<Product> cartProducts) {
            tableModel.setRowCount(0);

            for (Product product : cartProducts) {
                Object[] rowData = {product.getProductID() + " ," + product.getProductName() + " , " + product.getInfo(),
                        product.getQuantity(), product.getProductPrice() * product.getQuantity()};
                tableModel.addRow(rowData);
            }
        }

        // Method to update the total labels with the cart information
        public void updateTotalLabels(ShoppingCart shoppingCart) {
            double total = 0;
            double categoryDiscount = 0;
            double firstPurchaseDiscount = 0;

            // Calculate the total price of the items in the cart
            for (Product product : shoppingCart.getCartProducts()) {
                total += product.getProductPrice() * product.getQuantity();
            }

            // Apply discounts based on the item count and user status
            if (getElectricItemCount() >= 3 || getClothingItemCount() >= 3) {
                categoryDiscount = total * 0.2;
            }

            if (shoppingCart.getUser().isNewUser()) {
                firstPurchaseDiscount = total * 0.1;
            }

            // Set the labels with the calculated values
            totalLabel.setText("Total: £   " + total);
            firstPurchaseDiscountLabel.setText("First Purchase Discount (10%): £" + firstPurchaseDiscount);
            categoryDiscountLabel.setText("Three items in the same category Discount (20%): £" + categoryDiscount);
            finalTotalLabel.setText("Final Total: £" + (total - firstPurchaseDiscount - categoryDiscount));
        }
    }

    // Method to retrieve the list of products in the cart
    public ArrayList<Product> getCartProducts() {
        return cartProducts;
    }
}
