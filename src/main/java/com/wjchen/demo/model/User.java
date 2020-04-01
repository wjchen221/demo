package com.wjchen.demo.model;

import com.wjchen.demo.base.BaseModel;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_user")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class User extends BaseModel {
    /**
     * 用户名
     */
    @Column(name="username")
    private String username;
    /**
     * 密码
     */
    @Column(name="password")
    private String password;
    /**
     * 微信openid
     */
    @Column(name="openid")
    private String openId;
    /**
     * 用户状态 1启用  0禁用
     */
    @Column(name="state")
    private String state;

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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", openId='" + openId + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
