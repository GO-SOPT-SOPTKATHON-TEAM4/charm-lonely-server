package com.sopt.sopkathonproduct.common.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class BaseEntity {

    @Column(name="created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public BaseEntity(LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
