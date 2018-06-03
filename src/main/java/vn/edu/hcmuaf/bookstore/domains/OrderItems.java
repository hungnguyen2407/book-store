package vn.edu.hcmuaf.bookstore.domains;

public class OrderItems {
    private int idBook;
    private int quantity;
    private double costPerItem;

    public OrderItems() {
        super();
    }

    public OrderItems(int idBook, int quantity, double costPerItem) {
        this.idBook = idBook;
        this.quantity = quantity;
        this.costPerItem = costPerItem;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
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
