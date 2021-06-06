package com.ligang.whiteelephant.entity.home;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

@Entity
@Table(name = "t_seconds")
@ApiModel(value="秒杀类",description="获取秒杀详情" )
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
