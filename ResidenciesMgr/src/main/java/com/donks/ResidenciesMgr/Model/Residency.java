package com.donks.ResidenciesMgr.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "residency")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Residency {

    @Id
    @Column(name ="id", columnDefinition = "uuid")
    @GeneratedValue
    @GenericGenerator(
            name = "uuid",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @Column(name ="street")
    private String street;
    @Column(name ="bt_street_1")
    private String between_street_1;
    @Column(name ="bt_street_2")
    private String between_street_2;
    @Column(name="num")
    private int numeration;
    @Column(name="orientation")
    private String orientation;
    @Column(name="extra_comment")
    private String comment;

    private UUID userId;
}
