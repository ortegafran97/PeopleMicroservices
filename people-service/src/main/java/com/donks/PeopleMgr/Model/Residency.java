package com.donks.PeopleMgr.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Residency {
    private UUID id;
    private String street;
    private String between_street_1;
    private String between_street_2;
    private int numeration;
    private String orientation;
    private String comment;
    private UUID personid;

}
