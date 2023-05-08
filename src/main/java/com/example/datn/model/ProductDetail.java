package com.example.datn.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "product_detail", schema = "datn_en", catalog = "")
public class ProductDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Object id;
    @Basic
    @Column(name = "amount_serial_code")
    private Integer amountSerialCode;
    @Basic
    @Column(name = "unit_price")
    private Integer unitPrice;
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
    @Column(name = "id_product")
    private Object idProduct;
    @Basic
    @Column(name = "id_color")
    private Object idColor;
    @Basic
    @Column(name = "id_size")
    private Object idSize;
    @OneToMany(mappedBy = "productDetailByIdProductCt")
    private Collection<BillDetail> billDetailsById;
    @OneToMany(mappedBy = "productDetailByIdProductDetail")
    private Collection<CartDetail> cartDetailsById;
    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    private Product productByIdProduct;
    @ManyToOne
    @JoinColumn(name = "id_color", referencedColumnName = "id")
    private Color colorByIdColor;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Integer getAmountSerialCode() {
        return amountSerialCode;
    }

    public void setAmountSerialCode(Integer amountSerialCode) {
        this.amountSerialCode = amountSerialCode;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
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

    public Object getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Object idProduct) {
        this.idProduct = idProduct;
    }

    public Object getIdColor() {
        return idColor;
    }

    public void setIdColor(Object idColor) {
        this.idColor = idColor;
    }

    public Object getIdSize() {
        return idSize;
    }

    public void setIdSize(Object idSize) {
        this.idSize = idSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDetail that = (ProductDetail) o;
        return Objects.equals(id, that.id) && Objects.equals(amountSerialCode, that.amountSerialCode) && Objects.equals(unitPrice, that.unitPrice) && Objects.equals(createAt, that.createAt) && Objects.equals(updateAt, that.updateAt) && Objects.equals(status, that.status) && Objects.equals(idProduct, that.idProduct) && Objects.equals(idColor, that.idColor) && Objects.equals(idSize, that.idSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amountSerialCode, unitPrice, createAt, updateAt, status, idProduct, idColor, idSize);
    }

    public Collection<BillDetail> getBillDetailsById() {
        return billDetailsById;
    }

    public void setBillDetailsById(Collection<BillDetail> billDetailsById) {
        this.billDetailsById = billDetailsById;
    }

    public Collection<CartDetail> getCartDetailsById() {
        return cartDetailsById;
    }

    public void setCartDetailsById(Collection<CartDetail> cartDetailsById) {
        this.cartDetailsById = cartDetailsById;
    }

    public Product getProductByIdProduct() {
        return productByIdProduct;
    }

    public void setProductByIdProduct(Product productByIdProduct) {
        this.productByIdProduct = productByIdProduct;
    }

    public Color getColorByIdColor() {
        return colorByIdColor;
    }

    public void setColorByIdColor(Color colorByIdColor) {
        this.colorByIdColor = colorByIdColor;
    }
}
