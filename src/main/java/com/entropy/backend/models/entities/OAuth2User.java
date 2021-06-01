package com.entropy.backend.models.entities;

import com.entropy.backend.models.entities.base.Base;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ofOAuth2User")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OAuth2User extends Base {
    @Id
    @Column
    private Integer id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private Byte type;
}
