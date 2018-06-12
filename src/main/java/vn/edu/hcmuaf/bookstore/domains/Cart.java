package vn.edu.hcmuaf.bookstore.domains;

import java.util.List;

public class Cart {

    private int account;
    private List<OrderItems> listItems;
    private double total;

    public Cart() {
        super();
    }

    public Cart(int account, List<OrderItems> listItems, double total) {
        this.account = account;
        this.listItems = listItems;
        this.total = total;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public List<OrderItems> getListItems() {
        return listItems;
    }

    public void setListItems(List<OrderItems> listItems) {
        this.listItems = listItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void addItem(OrderItems orderItems) {
        total += orderItems.getQuantity() * orderItems.getCostPerItem();
        listItems.add(orderItems);
    }

    public void updateItem(int index, int quantity) {
        OrderItems orderItems = listItems.get(index);

        if (orderItems.getQuantity() > quantity) {
            total -= orderItems.getCostPerItem() * (orderItems.getQuantity() - quantity);
            orderItems.setQuantity(quantity);
        } else if (orderItems.getQuantity() < quantity) {
            total += orderItems.getCostPerItem() * (quantity - orderItems.getQuantity());
            orderItems.setQuantity(quantity);
        }

        listItems.set(index, orderItems);
    }

    public void rmItem(int index) {
        listItems.remove(index);
    }
}
