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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "product_detail", schema = "datn_en", catalog = "")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
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
    @OneToMany(mappedBy = "productDetail")
    private Collection<BillDetail> billDetails;
    @OneToMany(mappedBy = "productDetail")
    private Collection<CartDetail> cartDetails;
    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "id_color", referencedColumnName = "id")
    private Color color;
    @ManyToOne
    @JoinColumn(name = "id_size", referencedColumnName = "id")
    private Size size;
    @OneToMany(mappedBy = "productDetail")
    private Collection<SerialCode> serialCodes;

}
