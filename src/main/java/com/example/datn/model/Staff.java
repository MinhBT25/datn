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
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "staff_name")
    private String staffName;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "birthday")
    private Date birthday;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
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
    @Column(name = "id_position")
    private Object idPosition;
    @OneToMany(mappedBy = "staff")
    private Collection<Bill> bills;
    @ManyToOne
    @JoinColumn(name = "id_position", referencedColumnName = "id", nullable = false)
    private Position position;

}
