package com.example.datn.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "promotion_detail", schema = "datn_en", catalog = "")
public class PromotionDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Object id;
    @Basic
    @Column(name = "id_product")
    private Object idProduct;
    @Basic
    @Column(name = "id_promotion")
    private Object idPromotion;
    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    private Product productByIdProduct;
    @ManyToOne
    @JoinColumn(name = "id_promotion", referencedColumnName = "id")
    private Promotion promotionByIdPromotion;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Object idProduct) {
        this.idProduct = idProduct;
    }

    public Object getIdPromotion() {
        return idPromotion;
    }

    public void setIdPromotion(Object idPromotion) {
        this.idPromotion = idPromotion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PromotionDetail that = (PromotionDetail) o;
        return Objects.equals(id, that.id) && Objects.equals(idProduct, that.idProduct) && Objects.equals(idPromotion, that.idPromotion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idProduct, idPromotion);
    }

    public Product getProductByIdProduct() {
        return productByIdProduct;
    }

    public void setProductByIdProduct(Product productByIdProduct) {
        this.productByIdProduct = productByIdProduct;
    }

    public Promotion getPromotionByIdPromotion() {
        return promotionByIdPromotion;
    }

    public void setPromotionByIdPromotion(Promotion promotionByIdPromotion) {
        this.promotionByIdPromotion = promotionByIdPromotion;
    }
}
