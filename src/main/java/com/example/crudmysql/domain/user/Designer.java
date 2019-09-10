package com.example.crudmysql.domain.user;

import com.example.crudmysql.domain.Shop;

import javax.persistence.*;

@Entity
@AttributeOverride(name="id", column = @Column(name = "DESIGNER_ID"))
@Table(name = "DESIGNER", catalog = "test")
public class Designer extends User {
    private String snsUrl;
    private String profilePictureUrl;
    private String description;

    @ManyToOne
    @JoinColumn(name = "SHOP_ID")
    private Shop shop;


    // Getter
    public String getSnsUrl() {
        return snsUrl;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
