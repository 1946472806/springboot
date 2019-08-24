package org.sang.model;

import org.sang.interfaces.ValidationGroup1;
import org.sang.interfaces.ValidationGroup2;

import javax.validation.constraints.*;

public class ValidationGroupTable {
    private Integer id;
    @Size(min = 5, max = 10, message = "{validation.name.size}", groups = ValidationGroup1.class)
    private String name;

    @NotNull(message = "{validation.address.notnull}", groups = ValidationGroup2.class)
    private String address;

    @DecimalMin(value = "1", message = "{validation.age.size}")
    @DecimalMax(value = "200", message = "{validation.age.size}")
    private Integer age;

    @Email(message = "{validation.email.pattern}")
    @NotNull(message = "{validation.email.notnull}", groups = {ValidationGroup1.class, ValidationGroup2.class})
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
