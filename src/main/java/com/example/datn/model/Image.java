package com.example.datn.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Image {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "code")
    private String code;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "create_at")
    private Timestamp createAt;
    @Basic
    @Column(name = "update_at")
    private Timestamp updateAt;
    @Basic
    @Column(name = "id_product")
    private Object idProduct;
    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    private Product productByIdProduct;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Object getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Object idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(code, image.code) && Objects.equals(name, image.name) && Objects.equals(createAt, image.createAt) && Objects.equals(updateAt, image.updateAt) && Objects.equals(idProduct, image.idProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, createAt, updateAt, idProduct);
    }

    public Product getProductByIdProduct() {
        return productByIdProduct;
    }

    public void setProductByIdProduct(Product productByIdProduct) {
        this.productByIdProduct = productByIdProduct;
    }
}
