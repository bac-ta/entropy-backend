package com.entropy.backend.entity;

import com.entropy.backend.entity.base.Base;
import com.entropy.backend.enumeration.UserType;
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

/**
 * @author bac-ta
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "user_type")
    private UserType userType;

    public Role(UserType userType) {
        this.userType = userType;
    }
}
