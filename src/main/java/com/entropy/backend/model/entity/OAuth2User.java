package com.entropy.backend.model.entity;

import com.entropy.backend.model.enumeration.OAuth2Type;
import com.entropy.backend.model.entity.base.Base;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "oauth2_user", uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
@Entity
public class OAuth2User extends Base {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @Column(name = "oauth2_type")
    @Enumerated(value = EnumType.STRING)
    private OAuth2Type oAuth2Type;
}
