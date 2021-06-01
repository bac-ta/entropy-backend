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
@Table(name = "ofProfile")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Profile extends Base {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "description")
    private String description;

    @Column
    private String username;

    @Column(name = "oauth2UserId")
    private Integer oauth2UserId;

    @Column(name = "oauth2Avatar")
    private String oauth2Avatar;
}
