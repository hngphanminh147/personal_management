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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "category")
@Getter
@Setter
@Accessors(chain = true)
public class Category {
    @Id
    @GeneratedValue(generator = "category_id_generator")
    @SequenceGenerator(name = "category_id_generator")
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "category")
    private Set<Record> records;

    @ManyToOne
    @JoinColumn(
            name = "parent_category",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_category_category"))
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory")
    private Set<Category> subordinates;
}
