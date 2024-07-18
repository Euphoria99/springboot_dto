package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

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
