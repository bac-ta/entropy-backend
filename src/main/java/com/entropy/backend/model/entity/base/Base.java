package com.entropy.backend.model.entity.base;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author bac-ta
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Base {
    @Column
    @CreatedDate
    private LocalDateTime created;
    @Column
    @LastModifiedDate
    private LocalDateTime updated;
    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;
    @Column(name = "updated_by")
    @LastModifiedBy
    private String updatedBy;
}
