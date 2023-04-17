package org.example;

import javax.persistence.*;

@Entity
@Table(name="Menu")
public class Menu {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String name;
    private  int price;
    private double weight;
    private  String sale;

    public Menu() {
    }

    public Menu( String name, int price, double weight, String sale) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.sale = sale;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", sale='" + sale + '\'' +
                '}';
    }
}
