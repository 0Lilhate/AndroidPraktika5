package com.example.shop_project.Item;

public class Product implements Comparable<Product>{
    private Integer id;
    private String name;
    private Integer price;
    private String image;
    private Integer sale;

    public Product(Integer id, String name, Integer price, String image){
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public int compareTo(Product product) {
        if(this.price < product.price) return 1;
        else if(this.price == product.price) return 0;
        else return -1;
    }
}
