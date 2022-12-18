package com.example.contacts;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;


@Entity
class Contact {

    private @Id
    @GeneratedValue Long id;
    private String name;
    private int phone;
    private String email;

    Contact() {}

    Contact(String name, int phone, String email) {

        this.name = name;
        this.phone =phone;
        this.email = email;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getPhone() {
        return this.phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(int phone) {
        this.phone= phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Contact))
            return false;
        Contact employee = (Contact) o;
        return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name)
                && Objects.equals(this.phone, employee.phone) && Objects.equals(this.email, employee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.phone, this.email);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", phone='" + this.phone + '\'' + ", email='" + this.email + '\'' + '}';
    }
}
