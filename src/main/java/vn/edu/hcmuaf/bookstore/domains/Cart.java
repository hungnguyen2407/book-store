package vn.edu.hcmuaf.bookstore.domains;

import java.util.List;

public class Cart {

    private int account;
    private List<OrderItems> listItems;

    public Cart() {
        super();
    }

    public Cart(int account, List<OrderItems> listItems) {
        this.account = account;
        this.listItems = listItems;
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

    public boolean addOrderItems(OrderItems orderItems) {
        return listItems.add(orderItems);
    }
}
