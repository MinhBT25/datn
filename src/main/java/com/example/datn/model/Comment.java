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
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "content")
    private String content;
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
    @Column(name = "id_customer")
    private Object idCustomer;
    @Basic
    @Column(name = "id_product")
    private Object idProduct;
    @ManyToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    private Product product;

}
