package com.entropy.backend.model.entity;

import com.entropy.backend.model.enumeration.ApproveType;
import com.entropy.backend.model.enumeration.GenderType;
import com.entropy.backend.model.enumeration.StatusType;
import com.entropy.backend.model.enumeration.UserType;
import com.entropy.backend.model.entity.base.Base;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
import java.time.LocalDateTime;

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
    private LocalDateTime dateOfBirth;
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
    private UserType userType = UserType.GUEST;
}
