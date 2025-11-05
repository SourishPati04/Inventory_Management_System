# Inventory_Management_System #

Sure! Here is a clean, professional **README.md** you can directly place in your GitHub repository.

---

```markdown
# Inventory Management System

A simple desktop-based Inventory Management System built using **Java Swing**, **JDBC**, and **MySQL**.  
This application allows users to add products, manage stock levels, and view product data stored securely in a database.

---

## 🚀 Features
- Add new products to inventory
- View all stored products
- Stores data in MySQL database
- Simple and user-friendly interface built with Java Swing

---

## 🛠️ Tech Stack
| Layer | Technology |
|------|------------|
| Frontend (UI) | Java Swing |
| Backend Logic | Core Java (JDBC) |
| Database | MySQL |
| IDE Used | Eclipse / IntelliJ IDEA / VS Code |

---

## 📂 Project Structure
```

InventorySystem/
│
├─ src/
│   ├─ InventoryApp.java        # Main GUI Application
│   └─ DatabaseConnection.java  # JDBC Database Connection
│
└─ inventory_db.sql             # SQL script to create required table

````

---

## 🗄️ Database Setup

Run the following SQL commands in MySQL:

```sql
CREATE DATABASE inventory_db;
USE inventory_db;

CREATE TABLE product(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    quantity INT,
    price DOUBLE
);
````

---

## ⚙️ How to Run the Project

1. Install MySQL and create the `inventory_db` database (using SQL above).
2. Add the MySQL JDBC Connector JAR to your project classpath.
3. Update your MySQL username & password inside `DatabaseConnection.java`:

   ```java
   DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory_db", "root", "YOUR_PASSWORD");
   ```
4. Compile and run:

   ```sh
   javac *.java
   java InventoryApp
   ```

---

## 📸 Screenshots (Optional)

*Add UI images here later*

---

## 👤 Author

**Name:** Sourish Pati


## 📈 Future Enhancements

* Update and Delete product features
* Low-stock warning alerts
* Export inventory data to Excel/PDF
* Search and filter functionality
* Login authentication system

---

## ⭐ Support

If you like this project, don’t forget to **star** ⭐ the repository!




