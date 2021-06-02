package com.ligang.whiteelephant.entity.home;

import javax.persistence.*;

@Entity
@Table(name = "t_seconds")
public class Seconds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String icon;
    double price;
    double oldPrice;

    @Override
    public String toString() {
        return "Seconds{" +
                "id=" + id +
                ", icon='" + icon + '\'' +
                ", price=" + price +
                ", oldPrice=" + oldPrice +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }
}
