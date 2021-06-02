package com.ligang.whiteelephant.entity.home;


import javax.persistence.*;

@Entity
@Table(name = "t_activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String icon;

    @Override
    public String toString() {
        return "activity{" +
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
