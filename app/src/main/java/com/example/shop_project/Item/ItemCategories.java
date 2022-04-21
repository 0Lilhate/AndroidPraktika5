package com.example.shop_project.Item;

public class ItemCategories {
    private Integer id;
    private String name;
    public ItemCategories(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
