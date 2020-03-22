package com.entropy.backend.entity;

import com.entropy.backend.entity.base.Base;
import com.entropy.backend.enumeration.ApproveType;
import com.entropy.backend.enumeration.GenderType;
import com.entropy.backend.enumeration.StatusType;
import com.entropy.backend.enumeration.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;
    @Column(name = "gender_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private GenderType genderType;
    @Column(name = "user_name", nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(name = "status_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private StatusType statusType = StatusType.ON;
    @Column(name = "approve_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ApproveType approveType = ApproveType.WAITING;
    @Column(name = "user_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserType userType;
}
