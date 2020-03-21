package com.entropy.backend.entity;

import com.entropy.backend.entity.base.Base;
import com.entropy.backend.enumeration.ApproveType;
import com.entropy.backend.enumeration.GenderType;
import com.entropy.backend.enumeration.StatusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Collection;
import java.util.Date;

/**
 * @author bac-ta
 */

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"email", "user_name"}))
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class User extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "gender_type", columnDefinition = "varchar(45) default 'MALE'")
    @Enumerated(value = EnumType.STRING)
    private GenderType genderType;
    @Column(name = "user_name")
    private String userName;
    @Column
    private String password;
    @Column(name = "status_type", columnDefinition = "varchar(45) default 'ON'")
    @Enumerated(value = EnumType.STRING)
    private StatusType statusType;
    @Column(name = "approve_type", columnDefinition = "varchar(45) default 'WAITTING'")
    @Enumerated(value = EnumType.STRING)
    private ApproveType approveType;
}
