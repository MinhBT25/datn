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
@Table(name = "bill_detail", schema = "datn_en", catalog = "")
public class BillDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "unit_price")
    private Integer unitPrice;
    @Basic
    @Column(name = "amount")
    private Object amount;
    @Basic
    @Column(name = "note")
    private String note;
    @Basic
    @Column(name = "id_bill")
    private Object idBill;
    @Basic
    @Column(name = "id_product_ct")
    private Object idProductCt;
    @ManyToOne
    @JoinColumn(name = "id_bill", referencedColumnName = "id")
    private Bill bill;


}
