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
import javax.persistence.OneToOne;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
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
    @OneToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id")
    private Customer customer;
    @OneToMany(mappedBy = "cart")
    private Collection<CartDetail> cartDetails;

}
