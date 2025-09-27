import java.io.Serializable;

public abstract class Product implements Serializable {
    private String id;
    private String name;
    private String brand;
    private double price;
    private int quantity;

    public Product(String id, String name, String brand, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return "--------------------------\n" +
               "ID: " + id + "\n" +
               "Name: " + name + "\n" +
               "Brand: " + brand + "\n" +
               "Price: $" + price + "\n" +
               "Quantity: " + quantity + "\n" ;
               
    }

}