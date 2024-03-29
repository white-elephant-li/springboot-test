package com.ligang.whiteelephant.entity.user;



import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "t_user")
@ApiModel(value="用户类",description="获取用户详情" )
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;
    private String sessionId;
    private String loginTime;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", loginTime='" + loginTime + '\'' +
                '}';
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
