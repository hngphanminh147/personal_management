package com.self.serverservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Entity
@Table(name = "record")
@Getter
@Setter
@Accessors(chain = true)
public class Record extends AbstractAuditingModel {
    @Id
    @GeneratedValue(generator = "record_id_generator")
    @SequenceGenerator(name = "record_id_generator")
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "category_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_record_category"))
    private Category category;

    @ManyToOne
    @JoinColumn(
            name = "owner_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_record_user"))
    private User owner;

    @Column(name = "amount")
    @NotNull
    private Long amount;

    @Column(name = "note")
    private String note;

    @Column(name = "date")
    private OffsetDateTime date;
}
