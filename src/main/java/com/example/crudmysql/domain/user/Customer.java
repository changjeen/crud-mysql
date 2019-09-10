package com.example.crudmysql.domain.user;


import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@AttributeOverride(name="id", column = @Column(name = "CUSTOMER_ID"))
@Table(name = "CUSTOMER", catalog = "test")
public class Customer extends User{
    private String address; // ToDo : Address 객체 추가
    private String creditCardNumber;

    // getter
    public String getAddress() {
        return address;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }






}
