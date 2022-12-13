package com.donks.PeopleMgr.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobRecord {
    private UUID id;
    private String Role;
    private String enterprise;
    private LocalDateTime start;
    private LocalDateTime end;
    private UUID personid;

}
