package com.itheima.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountUser extends Account implements Serializable {
    private String username;
    private String address;

    @Override
    public String toString() {
        return super.toString() + "AccountUser{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
