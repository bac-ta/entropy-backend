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
@Table(name = "ofPermission")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Permission extends Base {
    @Id
    @Column(name = "id")
    private Byte id;

    @Column(name = "name")
    private String name;
}
