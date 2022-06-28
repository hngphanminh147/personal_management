package com.self.serverservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "user_info")
@Getter
@Setter
public class User extends AbstractAuditingModel{
    @Id
    @GeneratedValue(generator = "user_id_generator")
    @SequenceGenerator(name = "user_id_generator")
    private Long id;

    @OneToMany(mappedBy = "owner")
    private Set<Record> records;

    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String name;
}
