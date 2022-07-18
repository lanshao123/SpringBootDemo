package com.wh.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @program: SpringBootDemo
 * @description: Film
 * @author: wangheng
 * @create: 2022-07-18 16:07
 **/
public class Film {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    private String name;
    private String type;
    private String address;
    private Integer money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
