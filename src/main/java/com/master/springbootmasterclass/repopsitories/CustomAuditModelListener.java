package com.master.springbootmasterclass.repopsitories;

import com.master.springbootmasterclass.model.AuditModel;
import jakarta.persistence.PrePersist;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

public class CustomAuditModelListener extends AuditingEntityListener {

    @PrePersist
    public void onCreate(Object entity) {
        if (entity instanceof AuditModel) {
            AuditModel<?> auditModel = (AuditModel<?>) entity;
            // Set creation date and created by here
            auditModel.setCreationDate(LocalDateTime.now());
            // You need to set the created by user, for example, from a Spring Security context
            auditModel.setCreatedBy("abdullah");
        }
    }
}
