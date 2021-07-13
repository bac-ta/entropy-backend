package com.entropy.backend.models.entities;

import com.entropy.backend.models.entities.base.Base;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ofUser")
@AllArgsConstructor
@Data
@FieldNameConstants
public class User extends Base {
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "storedKey")
    private String storedKey;

    @Column(name = "serverKey")
    private String serverKey;

    @Column(name = "salt")
    private String salt;

    @Column(name = "iterations")
    private Integer iterations;

    @Column(name = "plainPassword")
    private String plainPassword;

    @Column(name = "encryptedPassword")
    private String encryptedPassword;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private Byte status;

    @Column(name = "gender")
    private Byte gender;

    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;

    @Column(name = "phone")
    private String phone;

    @JoinColumn(name = "role")
    @OneToOne(fetch = FetchType.LAZY)
    private Role role;

    @Column(name = "bcryptedPassword")
    private String bcryptedPassword;
}
