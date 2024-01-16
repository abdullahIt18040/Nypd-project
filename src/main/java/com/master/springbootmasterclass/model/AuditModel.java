package com.master.springbootmasterclass.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@MappedSuperclass
@EntityListeners(EntityListeners.class)
public abstract class AuditModel <U>{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @CreatedBy

    protected U createdBy;

    @LastModifiedBy

    protected U lastModifiedBy;

    @CreatedDate

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    protected LocalDateTime creationDate;

    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")

    protected LocalDateTime lastModifiedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonFormat(shape=JsonFormat.Shape.NUMBER, pattern="s")
    public Long getCreationDateTimeStamp() {
        if (creationDate == null) {
            return 0L;
        } else {
            return this.creationDate.toEpochSecond(OffsetDateTime.now().getOffset());
        }
    }

    @JsonFormat(shape=JsonFormat.Shape.NUMBER, pattern="s")
    public Long getLastModifiedDateTimeStamp() {
        if (lastModifiedDate == null) return 0L;
        return this.lastModifiedDate.toEpochSecond(OffsetDateTime.now().getOffset());
    }

    public U getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = (U) createdBy;
    }

    public U getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(U lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getCreatedDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm aa");

        String date = dateFormat.format(Date.from(this.creationDate.toInstant(ZoneOffset.UTC)));

        return date.substring(0,11)+"  at  "+date.substring(12);
    }
    @PrePersist
    public void prePersist() {
        // Set creation date and created by user before persisting
        this.setCreationDate(LocalDateTime.now());
        // You need to set the created by user, for example, from a Spring Security context
        this.setCreatedBy("abdullah");
        this.setLastModifiedBy((U) "abdullah");
       this.setLastModifiedDate(LocalDateTime.now());
    }

    private void lastModifiedDate(LocalDateTime now) {
    }

}
