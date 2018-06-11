package vn.edu.hcmuaf.bookstore.domains;

public class OrderItems {
    private int idBook;
    private String nameBook;
    private int quantity;
    private double costPerItem;

    public OrderItems() {
        super();
    }

    public OrderItems(int idBook, String nameBook, int quantity, double costPerItem) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.quantity = quantity;
        this.costPerItem = costPerItem;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCostPerItem() {
        return costPerItem;
    }

    public void setCostPerItem(double costPerItem) {
        this.costPerItem = costPerItem;
    }
}
