package com.donks.PeopleMgr.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "people")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class People {

    @Id
    @Column(name = "id_people",columnDefinition = "uuid")
    @GeneratedValue
    @GenericGenerator(
            name = "uuid",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column(name="dni")
    private String dni;

    @Column(name = "name")
    private String name;

    @Column(name = "firstlastname")
    private String firstLastName;

    @Column(name = "secondlastname")
    private String secondLastName;
}
