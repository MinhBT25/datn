package com.example.datn.model;

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
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Object id;
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
    @OneToMany(mappedBy = "productByIdProduct")
    private Collection<CategoryDetail> categoryDetailsById;
    @OneToMany(mappedBy = "productByIdProduct")
    private Collection<Comment> commentsById;
    @OneToMany(mappedBy = "productByIdProduct")
    private Collection<Image> imagesById;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public Boolean getBestSeller() {
        return isBestSeller;
    }

    public void setBestSeller(Boolean bestSeller) {
        isBestSeller = bestSeller;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(productCode, product.productCode) && Objects.equals(manufacturer, product.manufacturer) && Objects.equals(createAt, product.createAt) && Objects.equals(updateAt, product.updateAt) && Objects.equals(status, product.status) && Objects.equals(isNew, product.isNew) && Objects.equals(isBestSeller, product.isBestSeller) && Objects.equals(isActive, product.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, productCode, manufacturer, createAt, updateAt, status, isNew, isBestSeller, isActive);
    }

    public Collection<CategoryDetail> getCategoryDetailsById() {
        return categoryDetailsById;
    }

    public void setCategoryDetailsById(Collection<CategoryDetail> categoryDetailsById) {
        this.categoryDetailsById = categoryDetailsById;
    }

    public Collection<Comment> getCommentsById() {
        return commentsById;
    }

    public void setCommentsById(Collection<Comment> commentsById) {
        this.commentsById = commentsById;
    }

    public Collection<Image> getImagesById() {
        return imagesById;
    }

    public void setImagesById(Collection<Image> imagesById) {
        this.imagesById = imagesById;
    }
}
