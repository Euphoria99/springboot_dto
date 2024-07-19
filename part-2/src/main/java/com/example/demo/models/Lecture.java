package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Lecture extends Auditable{


    private int name;

    //relation
    //lecture is the owner of the relation
    @ManyToOne
    @JoinColumn(name="section_id")
    private Section section;

    //uni directional onetoone
    @OneToOne
    @JoinColumn(name="resource_id")
    private Resource resource;
}
