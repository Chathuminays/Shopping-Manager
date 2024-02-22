import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WestminsterShoppingManager implements ShoppingManager {
    //Initialize instance variables
    private static ArrayList<Product> productList;
    private static ArrayList<User> userList;
    private static Scanner input;

    public WestminsterShoppingManager() {
        productList = new ArrayList<>();
        userList = new ArrayList<>();
        input = new Scanner(System.in);
    }

    public static void main(String[] args) throws Exception {
        WestminsterShoppingManager shoppingManager = new WestminsterShoppingManager();
        shoppingManager.managerConsole();
    }

//    Console menu implementation
    public void managerConsole() throws Exception {
        boolean flag = true;
        while (flag) {
            System.out.println(" ");
            System.out.println("-------------------------------------------------");
            System.out.println("Please Select an Option:");
            System.out.println("1) Add a New Product");
            System.out.println("2) Delete a Product");
            System.out.println("3) Print All Products");
            System.out.println("4) Save Products to File");
            System.out.println("5) Load Products From File");
            System.out.println("6) User Console");
            System.out.println("0) Quit");
            System.out.print("\nEnter an option: ");

//            Validating input as an integer
            if (!input.hasNextInt()) {
                System.out.println("\nInvalid input, Please enter an integer");
                input.next();
                continue;
            }
            int option = input.nextInt();

            input.nextLine();

            switch (option) {
                case 1:
                    //                    Call addProduct method
                    addProduct();
                    break;
                case 2:
                    //                    Call deleteProduct method
                    deleteProduct();
                    break;
                case 3:
                    //                    Call printProducts method
                    printProducts();
                    break;
                case 4:
                    //                    Call saveToFile method
                    saveToFile();
                    break;
                case 5:
                    //                    Call readFromFile method
                    readFromFile();
                    break;
                case 6:
                    //                    Call user method
                    user();
                    break;
                case 0:
                    //                    Close program
                    System.out.println("Program end ....");
                    flag = false;
                    break;
                default:
                    //                    Validate option input
                    System.out.println("Invalid Option");
                    System.out.println(" ");
            }
        }
    }

//    add products to the system
    @Override
    public  void addProduct() {
        int choice = 0, noOfAvailableItems, warrantyTimePeriod;
        String productId;
        double productPrice;

//        get required details
        while (true){
            if (productList.size() == 50){
                System.out.println("Maximum Amount of Products Reached!!");
                break;
            }
            System.out.print("What Do You Want to Add? (1 : Electronics, 2: Cloths)");
            if (!input.hasNextInt()) {
                System.out.println("Invalid input, Please Enter an Integer \n");
                input.next();
                continue;
            }

            choice = input.nextInt();
            input.nextLine();
            break;
        }

//        divide product according to category
        if (choice == 1) {
            while (true) {
                System.out.print("Enter Product ID: ");
                productId = input.next();

                for (Product product: productList){
                    if (product.getProductID().equals(productId)){
                        System.out.println("This ProductID is Already entered.");
                        return;
                    }
                }
                break;
            }

            System.out.print("Enter Product Name: ");
            String productName = input.next();

            while (true){
                try {
                    System.out.print("Enter No of Available Items: ");
                    noOfAvailableItems = input.nextInt();
                    break;
                } catch (Exception e){
                    System.out.println("Please enter an Integer \n");
                    input.nextLine();
                }
            }

            while (true){
                try {
                    System.out.print("Enter Product Price: ");
                    productPrice = input.nextDouble();
                    break;

                } catch (Exception e){
                    System.out.println("Please enter an valid price\n");
                    input.nextLine();
                }
            }


            System.out.print("Enter Product Brand: ");
            String productBrand = input.next();

            while (true){
                try {
                    System.out.print("Enter Warranty Time Period: ");
                    warrantyTimePeriod = input.nextInt();
                    break;

                } catch (Exception e){
                    System.out.println("Please enter an Integer \n");
                    input.nextLine();
                }
            }

            //creating a new product in Electronics class
            Product product = new Electronics(productId, productName, noOfAvailableItems, productPrice, productBrand, warrantyTimePeriod);
            //add created product to the productList
            productList.add(product);
            System.out.println("\nNew Product Added Successfully \n");

        } else if (choice == 2) {
            while (true) {
                System.out.print("Enter Product ID: ");
                productId = input.next();

                for (Product product: productList){
                    if (product.getProductID().equals(productId)){
                        System.out.println("This ProductID is Already entered.");
                        return;
                    }
                }
                break;
            }

            System.out.print("Enter Product Name: ");
            String productName = input.next();

            while (true){
                try {
                    System.out.print("Enter No of Available Items: ");
                    noOfAvailableItems = input.nextInt();
                    break;
                } catch (Exception e){
                    System.out.println("Please enter an Integer \n");
                    input.nextLine();
                }
            }

            while (true){
                try {
                    System.out.print("Enter Product Price: ");
                    productPrice = input.nextDouble();
                    break;

                } catch (Exception e){
                    System.out.println("Please enter an valid price\n");
                    input.nextLine();
                }
            }

            System.out.print("Enter Cloth Size: ");
            String clothSize = input.next();

            System.out.print("Enter Cloth Color: ");
            String clothColor = input.next();

            //create new product in Clothing class
            Product product = new Clothing(productId, productName, noOfAvailableItems, productPrice, clothSize, clothColor);
            // adding product to the productList
            productList.add(product);
            System.out.println("\nNew Product Added Successfully \n");
        }
        else {
            System.out.println("Invalid Input");
        }
    }

    @Override
    public void deleteProduct() {
//        Get productID to delete the product
        System.out.print("Enter Product ID to Delete: ");
        String delete = input.next();

//        check for a product with provided ID
        for (Product product : productList) {
            if (product.getProductID().equals(delete)) {
//                Delete the product from the arraylist
                productList.remove(product);
                System.out.println("\nProduct Removed Successfully \n");
                System.out.println("Available Product Count: " + productList.size());
                return;
            }
        }
        System.out.println("There is no Available Product with the provided Product ID \n");
    }

    @Override
    public void printProducts() {
//        Use BubbleSort method to sort products according to alphabetical order by ProductID
        for (int i = 0; i < productList.size() - 1; i++) {
            for (int j = 0; j < productList.size() - i - 1; j++) {
                String id1 = productList.get(j).getProductID();
                String id2 = productList.get(j + 1).getProductID();

                if (id1.compareTo(id2) > 0) {
                    Collections.swap(productList, j, j + 1);
                }
            }
        }
        System.out.println("\n");
//        print Products
        for (Product product : productList) {
            product.printProducts();
        }
    }

    @Override
    public void saveToFile() throws IOException {
        File inputFile = new File("Text.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(inputFile));
        for (Product product : productList) {
            oos.writeObject(product);
        }
        oos.close();
        System.out.println("Products saved to the file.\n");
    }

    @Override
    public void readFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Text.txt"))) {
            while (true) {
                try {
                    Product obj = (Product) ois.readObject();
                    productList.add(obj);
                } catch (EOFException eofException) {
                    break;
                }
            }
            System.out.println("Products loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

//    Validate user login
    public static User userLogin(){
        System.out.print("Enter Username: ");
        String username = input.next();
        System.out.print("Enter Password: ");
        String password = input.next();

//        check whether the user is a new user
        for (User user : userList){
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                user.setNewUser(false);
                return user;
            }
        }

        User customer = new User(username, password, true);
        userList.add(customer);
        return customer;
    }

//    Build the GUI for the User
    public static void user() {
        User user = userLogin();
        ShoppingCart cart = new ShoppingCart(user);
        UserConsole myFrame = new UserConsole(cart);
        myFrame.setSize(750, 600);
        myFrame.setTitle("Westminster Shopping Center");
        myFrame.setLocationRelativeTo(null);
        myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        myFrame.setVisible(true);
    }

    public static class UserConsole extends JFrame {

        private final JTable table;
        private final JTextArea footerTextArea;
        private final ShoppingCart shoppingCart;

        public UserConsole(ShoppingCart shoppingCart) {
            this.shoppingCart = shoppingCart;

            JPanel main = new JPanel();
            main.setBackground(Color.ORANGE);
            JPanel head = new JPanel(new BorderLayout());
            head.setPreferredSize(new Dimension(700, 70));

            JPanel p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            p1.setBackground(Color.ORANGE);
            p1.setPreferredSize(new Dimension(700, 30));
            JButton cartButton = new JButton("Shopping Cart");
            p1.add(cartButton);
            head.add(p1, BorderLayout.CENTER);

            cartButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ShoppingCart.ShoppingCartFrame(shoppingCart);
                }
            });

            JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
            p2.setBackground(Color.ORANGE);
            JLabel categoryLabel = new JLabel("Select Product Category");
            p2.add(categoryLabel);
            String[] categories = {"All", "Electronics", "Clothing"};
            JComboBox<String> categoryComboBox = new JComboBox<>(categories);
            p2.add(categoryComboBox);
            head.add(p2, BorderLayout.SOUTH);


            main.add(head, BorderLayout.NORTH);

            String[] columnNames = {"Product ID", "Product Name", "Category", "Price(£)", "Info"};
            Object[][] rowData = new Object[productList.size()][columnNames.length];

            categoryComboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String selectedCategory = (String) categoryComboBox.getSelectedItem();
                    updateTableData(selectedCategory);
                }
            });

            for (int i = 0; i < productList.size() - 1; i++) {
                for (int j = 0; j < productList.size() - i - 1; j++) {
                    String id1 = productList.get(j).getProductID();
                    String id2 = productList.get(j + 1).getProductID();

                    if (id1.compareTo(id2) > 0) {
                        Collections.swap(productList, j, j + 1);
                    }
                }
            }

            for (int i = 0; i < productList.size(); i++) {
                Product product = productList.get(i);
                rowData[i][0] = product.getProductID();
                rowData[i][1] = product.getProductName();
                rowData[i][2] = product.getCategory();
                rowData[i][3] = product.getProductPrice();
                rowData[i][4] = product.getInfo();
            }

            table = new JTable();
            TableModel model = new DefaultTableModel(rowData, columnNames);
            table.setModel(model);
            table.setGridColor(Color.ORANGE);
            table.setPreferredScrollableViewportSize(new Dimension(700, 150));

            JScrollPane scrollPane = new JScrollPane(table);

            JPanel content = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 45));
            content.setBackground(Color.ORANGE);
            content.add(scrollPane);

            main.add(content);

            JPanel footer = new JPanel(new BorderLayout());
            footer.setBackground(Color.ORANGE);
            footer.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));
            footer.setPreferredSize(new Dimension(750, 200));

            JLabel footerTitle = new JLabel("Selected Product - Details");
            footerTitle.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
            footer.add(footerTitle, BorderLayout.NORTH);

            footerTextArea = new JTextArea(5, 20);
            footerTextArea.setEditable(false);
            footerTextArea.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
            footer.add(footerTextArea, BorderLayout.CENTER);

            JPanel addToCartPanel = new JPanel(new FlowLayout());
            addToCartPanel.setBackground(Color.ORANGE);
            JButton addToCartButton = new JButton("Add to Shopping Cart");
            addToCartPanel.add(addToCartButton);

            addToCartButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        addSelectedProductToCart(selectedRow);
                    }
                }
            });

            footer.add(addToCartPanel, BorderLayout.SOUTH);

            main.add(footer);

            table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        int selectedRow = table.getSelectedRow();
                        if (selectedRow != -1) {
                            updateFooterTextArea(selectedRow);
                        }
                    }
                }
            });

            this.add(main);
        }

        private void addSelectedProductToCart(int selectedRow) {
            String productID = table.getValueAt(selectedRow, 0).toString();

            for (Product product : productList) {
                if (product.getProductID().equals(productID)) {
                    shoppingCart.addToCart(product);
                    break;
                }
            }
        }

        public void updateTableData(String selectedCategory) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            for (Product product : productList) {
                if (selectedCategory.equals("All")) {
                    Object[] rowData = {product.getProductID(), product.getProductName(), product.getCategory(), product.getProductPrice(), product.getInfo()};
                    model.addRow(rowData);
                }
                else if (selectedCategory.equals("Electronics") && product.getCategory().equals("Electronics")) {
                    Object[] rowData = {product.getProductID(), product.getProductName(), product.getCategory(), product.getProductPrice(), product.getInfo()};
                    model.addRow(rowData);
                }
                else if(selectedCategory.equals("Clothing") && product.getCategory().equals("Clothing")) {
                    Object[] rowData = {product.getProductID(), product.getProductName(), product.getCategory(), product.getProductPrice(), product.getInfo()};
                    model.addRow(rowData);
                }
            }
        }

        public void updateFooterTextArea(int selectedRow) {
            String productID = table.getValueAt(selectedRow, 0).toString();
            String footerText = "";

            for (Product product: productList){
                if (product.getProductID().equals(productID)){
                    footerText =
                    "Product ID: " + productID + "\n" +
                    "Category: " + product.getCategory() + "\n" +
                    "Product Name: " + product.getProductName() + "\n" +
                    product.getUniqueValue() +
                    "Price: £" + product.getProductPrice() + "\n" +
                    "Items Available: " + product.getNoAvailableItems();
                    break;
                }
            }
            footerTextArea.setText(footerText);
        }
    }

}


