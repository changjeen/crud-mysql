package com.example.crudmysql.domain;

import com.example.crudmysql.domain.user.Designer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SHOP", catalog = "test")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHOP_ID")
    private Long id;

    private String name;
    private String email;
    private String description;
    private String snsUrl;
    private String profilePictureUrl;
    private String taxNumber;

    @OneToMany(mappedBy = "shop"
            ,cascade = CascadeType.PERSIST
            ,fetch = FetchType.EAGER)
    private List<Designer> designers  = new ArrayList<Designer>();

    // Shop 생성
    public static Shop createShop(Shop shop, Designer designer) {
        shop.addDesigner(designer);
        return shop;
    }

    public void addDesigner(Designer designer){
        if (designer != null) {
            if (designers == null) {
                designers = new ArrayList<Designer>();
            }
            designers.add(designer);
            designer.setShop(this);
        }
    }

    // Getter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public String getSnsUrl() {
        return snsUrl;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public List<Designer> getDesigners() {
        return designers;
    }

}

