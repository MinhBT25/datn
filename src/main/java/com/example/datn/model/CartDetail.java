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
@Table(name = "cart_detail", schema = "datn_en", catalog = "")
public class CartDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "id_cart")
    private Object idCart;
    @Basic
    @Column(name = "id_product_detail")
    private Object idProductDetail;
    @ManyToOne
    @JoinColumn(name = "id_cart", referencedColumnName = "id")
    private Cart cartByIdCart;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getIdCart() {
        return idCart;
    }

    public void setIdCart(Object idCart) {
        this.idCart = idCart;
    }

    public Object getIdProductDetail() {
        return idProductDetail;
    }

    public void setIdProductDetail(Object idProductDetail) {
        this.idProductDetail = idProductDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartDetail that = (CartDetail) o;
        return Objects.equals(id, that.id) && Objects.equals(idCart, that.idCart) && Objects.equals(idProductDetail, that.idProductDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idCart, idProductDetail);
    }

    public Cart getCartByIdCart() {
        return cartByIdCart;
    }

    public void setCartByIdCart(Cart cartByIdCart) {
        this.cartByIdCart = cartByIdCart;
    }
}
