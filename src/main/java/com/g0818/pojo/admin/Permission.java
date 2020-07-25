package com.g0818.pojo.admin;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Permission {
    private int id;
    private String permName;
    private  String permTag;
    private String url;

    public String getPermTag() {
        return permTag;
    }
}
