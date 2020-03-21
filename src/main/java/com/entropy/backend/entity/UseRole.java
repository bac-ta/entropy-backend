package com.entropy.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UseRole {
    @Column(name = "user_id")
    private Long userId;
    private Long roleId;
}
