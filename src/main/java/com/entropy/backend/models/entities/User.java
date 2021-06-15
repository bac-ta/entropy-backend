package com.entropy.backend.models.entities;

import com.entropy.backend.models.entities.base.Base;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ofUser")
@AllArgsConstructor
@NoArgsConstructor
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

    @Column
    private Byte status;

    @Column
    private Byte gender;

    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;

    @Column
    private String phone;

    @Column
    private Byte type;

    @Column(name = "bcryptedPassword")
    private String bcryptedPassword;
}
