package com.ligang.whiteelephant.entity.home;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

@Entity
@Table(name = "t_swiper")
@ApiModel(value="轮播图类",description="获取轮播图url" )
public class Swiper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String icon;

    @Override
    public String toString() {
        return "swiper{" +
                "id=" + id +
                ", icon='" + icon + '\'' +
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
}
