package vn.edu.hcmuaf.bookstore.domains;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_order", nullable = false)
    private int id;

    @Column(name = "books", nullable = false)
    private String books;

    @Column(name = "cost", nullable = false)
    private Double cost;

    public Order() {
        super();
    }

    public Order(String books, Double cost) {
        this.books = books;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBooks() {
        return books;
    }

    public void setBooks(String books) {
        this.books = books;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
