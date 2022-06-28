package com.self.serverservice.model;

import com.self.serverservice.model.emun.AuthorityRoleEnum;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.OffsetDateTime;

@MappedSuperclass
@EntityListeners(EntityEventListener.class)
@Setter
public class AbstractAuditingModel {
    @Column(name = "creator_email", nullable = true)
    private String creatorEmail;

    @Column(name = "created_date", nullable = true)
    private OffsetDateTime createdDate;

    @Column(name = "updater_email", nullable = true)
    private String updaterEmail;

    @Column(name = "updated_date", nullable = true)
    private OffsetDateTime updatedDate;

    @Column(name = "deleter_email", nullable = true)
    private String deleterEmail;

    @Column(name = "deleted_date", nullable = true)
    private OffsetDateTime deletedDate;

    @Column(name = "is_deleted", nullable = true)
    private boolean isDeleted;
}

class EntityEventListener {
    @PrePersist
    public void preCreate(AbstractAuditingModel model) {
        model.setCreatedDate(OffsetDateTime.now());
        model.setCreatorEmail(AuthorityRoleEnum.ANONYMOUS.getRole());
    }

    @PreUpdate
    public void preUpdate(AbstractAuditingModel model) {
        model.setUpdatedDate(OffsetDateTime.now());
        model.setUpdaterEmail(AuthorityRoleEnum.ANONYMOUS.getRole());
    }
}