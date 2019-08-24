package org.sang.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
//@ConfigurationProperties(prefix = "book") //映射绑定
public class Book implements Serializable {
    private Integer id;
    private String name;
    private String author;
    @JsonIgnore
    private Float price;

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
