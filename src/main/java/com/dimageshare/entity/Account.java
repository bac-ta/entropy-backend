package com.dimageshare.entity;

import com.dimageshare.enumeration.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    @Column
    private String id;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    @Column(name = "phone_number")
    private String phoneNumber;
    @NotBlank
    @Column
    private String password;
    @Column(name = "type", length = 20)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
}
