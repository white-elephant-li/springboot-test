package com.ligang.whiteelephant.entity.home.Goods_all;

import javax.persistence.*;

@Entity
@Table(name = "t_swiper_img")
public class SwiperImg {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String img;

    @Override
    public String toString() {
        return "SwiperImg{" +
                "id=" + id +
                ", img='" + img + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
