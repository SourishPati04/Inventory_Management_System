import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class InventoryApp extends JFrame {

    JTextField nameField, qtyField, priceField;
    JTextArea displayArea;

    public InventoryApp() {
        setTitle("Inventory Management System");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Product Name:"));
        nameField = new JTextField(20);
        add(nameField);

        add(new JLabel("Quantity:"));
        qtyField = new JTextField(20);
        add(qtyField);

        add(new JLabel("Price:"));
        priceField = new JTextField(20);
        add(priceField);

        JButton addBtn = new JButton("Add Product");
        add(addBtn);

        JButton showBtn = new JButton("Show Products");
        add(showBtn);

        displayArea = new JTextArea(10,30);
        add(new JScrollPane(displayArea));

        addBtn.addActionListener(e -> addProduct());
        showBtn.addActionListener(e -> showProducts());
    }

    void addProduct() {
        try {
            Connection con = DatabaseConnection.getConnection();
            String sql = "INSERT INTO product(name,quantity,price) VALUES(?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nameField.getText());
            pst.setInt(2, Integer.parseInt(qtyField.getText()));
            pst.setDouble(3, Double.parseDouble(priceField.getText()));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Product Added Successfully");
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    void showProducts() {
        displayArea.setText("");
        try {
            Connection con = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM product";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
                displayArea.append(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getInt("quantity") + " | " +
                                rs.getDouble("price") + "\n"
                );
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args){
        new InventoryApp().setVisible(true);
    }
}
