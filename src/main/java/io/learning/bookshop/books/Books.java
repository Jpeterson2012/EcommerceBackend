package io.learning.bookshop.books;

//import io.learning.bookshop.purchases.Purchases;
//import io.learning.bookshop.sales.Sales;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public final class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private string isbn;
    private String name;
    private String auth;
    private int year;
    private string publisher;
    private string image;
    private float price;
    private String qty;

//    @OneToMany(mappedBy = "books", cascade = CascadeType.ALL)
//    private Set<Purchases> purchases;
//
//    @OneToMany(mappedBy = "books2",cascade = CascadeType.ALL)
//    private Set<Sales> sales;

    public Books() {}
    public Books(String isbn, String name, String auth, int year, String publisher, String image, float price, String qty) {
        this.isbn = isbn;
        this.name = name;
        this.auth = auth;
        this.year = year;
        this.publisher = publisher;
        this.image = image;
        this.price = price;
        this.qty = qty;
    }

    public int getId() {return id;}

    public string getIsbn() {return isbn;}
    public String getName() {return name;}
    public String getAuth() {return auth;}
    public int getYear() {return year;}
    public string getPublisher() {return publisher;}
    public string getImage() {return image;}
    public float getPrice() {return price;}
    public String getQty() {return qty;}

    public void setId(int id) {this.id = id;}

    public void setIsbn(string isbn) {this.isbn = isbn;}
    public void setName(String name) {this.name = name;}
    public void setAuth(String auth) {this.auth = auth;}
    public void setYear(int year) {this.year = year;}
    public void setPublisher(string publisher) {this.publisher = publisher;}
    public void setImage(string image) {this.image = image;}
    public void setPrice(float price) {this.price = price;}
    public void setQty(String qty) {this.qty = qty;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return id == books.id && Objects.equals(isbn, books.isbn) && Objects.equals(name, books.name) && Objects.equals(auth, books.auth) && Objects.equals(year, books.year)
                && Objects.equals(publisher, books.publisher) && Objects.equals(image, books.image) && Objects.equals(price, books.price) && Objects.equals(qty, books.qty) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, name, auth, year, publisher, image, price, qty);
    }
}
