package com.entropy.backend.entity.base;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @author bac-ta
 */
@Data
@MappedSuperclass
public class Base {
    @Column
    @CreatedDate
    private Date created;
    @Column
    @LastModifiedDate
    private Date updated;
    @Column(name = "created_by")
    @CreatedBy
    private Date createdBy;
    @Column(name = "updated_by")
    @LastModifiedBy
    private Date updatedBy;
}
