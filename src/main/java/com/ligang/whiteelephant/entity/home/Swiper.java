package com.ligang.whiteelephant.entity.home;

import javax.persistence.*;

@Entity
@Table(name = "t_swiper")
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
