package com.entropy.backend.entity;

import com.entropy.backend.entity.base.Base;
import com.entropy.backend.enumeration.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author bac-ta
 */

@Entity
@Data
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"user_type"}))
@AllArgsConstructor
@NoArgsConstructor
public class Role extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "user_type", columnDefinition = "varchar(45)")
    private UserType userType;

    public Role(UserType userType) {
        this.userType = userType;
    }
}
