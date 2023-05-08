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
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "serial_code", schema = "datn_en", catalog = "")
public class SerialCode {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Object id;
    @Basic
    @Column(name = "serial_code")
    private String serialCode;
    @Basic
    @Column(name = "import_date")
    private Timestamp importDate;
    @Basic
    @Column(name = "sale_date")
    private Timestamp saleDate;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "id_product_detail")
    private Object idProductDetail;
    @ManyToOne
    @JoinColumn(name = "id_product_detail", referencedColumnName = "id", nullable = false)
    private ProductDetail productDetailByIdProductDetail;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getSerialCode() {
        return serialCode;
    }

    public void setSerialCode(String serialCode) {
        this.serialCode = serialCode;
    }

    public Timestamp getImportDate() {
        return importDate;
    }

    public void setImportDate(Timestamp importDate) {
        this.importDate = importDate;
    }

    public Timestamp getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Timestamp saleDate) {
        this.saleDate = saleDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        SerialCode that = (SerialCode) o;
        return Objects.equals(id, that.id) && Objects.equals(serialCode, that.serialCode) && Objects.equals(importDate, that.importDate) && Objects.equals(saleDate, that.saleDate) && Objects.equals(status, that.status) && Objects.equals(idProductDetail, that.idProductDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serialCode, importDate, saleDate, status, idProductDetail);
    }

    public ProductDetail getProductDetailByIdProductDetail() {
        return productDetailByIdProductDetail;
    }

    public void setProductDetailByIdProductDetail(ProductDetail productDetailByIdProductDetail) {
        this.productDetailByIdProductDetail = productDetailByIdProductDetail;
    }
}
