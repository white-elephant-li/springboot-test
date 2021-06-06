package com.ligang.whiteelephant.entity.home.Goods_all;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

@Entity
@Table(name = "t_details_img")
@ApiModel(value="商品细节图类",description="请求图片url" )
public class DetailsImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String img;

    @Override
    public String toString() {
        return "DetailsImg{" +
                "id=" + id +
                ", img='" + img + '\'' +
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
}
