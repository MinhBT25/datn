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
import java.util.Objects;

@Entity
@Table(name = "promotion_detail", schema = "datn_en", catalog = "")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PromotionDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "id_product")
    private Object idProduct;
    @Basic
    @Column(name = "id_promotion")
    private Object idPromotion;
    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "id_promotion", referencedColumnName = "id")
    private Promotion promotion;

}
