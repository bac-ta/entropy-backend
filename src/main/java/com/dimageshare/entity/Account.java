package com.dimageshare.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * @author bac-ta
 */
@Entity
@Data
@Table(name = "accounts")
@EntityListeners(AuditingEntityListener.class)
@Builder
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String adminId;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    @Column(name = "phone_number")
    private String phoneNumber;
    @NotBlank
    @Column(length = 20)
    private String password;
}
