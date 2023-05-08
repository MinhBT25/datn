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
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "serial_code", schema = "datn_en", catalog = "")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SerialCode {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
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
    @ManyToOne
    @JoinColumn(name = "id_product_detail", referencedColumnName = "id", nullable = false)
    private ProductDetail productDetail;

}
