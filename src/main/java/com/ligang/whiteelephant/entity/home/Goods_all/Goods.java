package com.ligang.whiteelephant.entity.home.Goods_all;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_goods")
@ApiModel(value="商品类",description="获取商品详情" )
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String img;
    private boolean isDirect;



    private boolean isHave;
    private String name;
    private double price;
    private int volume;
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "GOODS_ID")
    private List<SwiperImg> swiperImg;

    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "GOODS_ID")
    private List<DetailsImg> detailsImg;

    public Goods() {
        this.swiperImg = new ArrayList<SwiperImg>();
        this.detailsImg = new ArrayList<DetailsImg>();
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", isDirect=" + isDirect +
                ", isHave=" + isHave +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", volume=" + volume +
                ", swiperImg=" + swiperImg +
                ", detailsImg=" + detailsImg +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    public void setisDirect(Boolean isDirect) {
        this. isDirect =isDirect;
    }

    public void setisHave(Boolean isHave) {
        this.isHave = isHave;
    }

    public Boolean getisDirect(){
        return isDirect;
    }

    public Boolean getisHave(){
        return isHave;
    }



    public void setDirect(boolean direct) {
        isDirect = direct;
    }



    public void setHave(boolean have) {
        isHave = have;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public List<SwiperImg> getSwiperImg() {
        return swiperImg;
    }

    public void setSwiperImg(List<SwiperImg> swiperImg) {
        this.swiperImg = swiperImg;
    }

    public List<DetailsImg> getDetailsImg() {
        return detailsImg;
    }

    public void setDetailsImg(List<DetailsImg> detailsImg) {
        this.detailsImg = detailsImg;
    }
}
