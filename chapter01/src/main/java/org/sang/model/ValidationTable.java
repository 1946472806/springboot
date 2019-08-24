package org.sang.model;

import javax.validation.constraints.*;

public class ValidationTable {
    private Integer id;
    @Size(min = 5, max = 10, message = "{validation.name.size}")
    private String name;

    @NotNull(message = "{validation.address.notnull}")
    private String address;

    @DecimalMin(value = "1", message = "{validation.age.size}")
    @DecimalMax(value = "200", message = "{validation.age.size}")
    private Integer age;

    @Email(message = "{validation.email.pattern}")
    @NotNull(message = "{validation.email.notnull}")
    private String email;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
