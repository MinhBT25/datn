package com.example.datn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "product_code")
    private String productCode;
    @Basic
    @Column(name = "manufacturer")
    private String manufacturer;
    @Basic
    @Column(name = "create_at")
    private Timestamp createAt;
    @Basic
    @Column(name = "update_at")
    private Timestamp updateAt;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "is_new")
    private Boolean isNew;
    @Basic
    @Column(name = "is_best_seller")
    private Boolean isBestSeller;
    @Basic
    @Column(name = "is_active")
    private Boolean isActive;
    @OneToMany(mappedBy = "product")
    private Collection<CategoryDetail> categoryDetails;
    @OneToMany(mappedBy = "product")
    private Collection<Comment> comments;
    @OneToMany(mappedBy = "product")
    private Collection<Image> images;
    @OneToMany(mappedBy = "product")
    private Collection<ProductDetail> productDetails;
    @OneToMany(mappedBy = "product")
    private Collection<PromotionDetail> promotionDetails;

}
