package com.donks.JobMgr.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="job")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobRecord {
    @Id
    @Column(name="id_job",columnDefinition = "uuid")
    @GeneratedValue
    @GenericGenerator(
            name = "uuid",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String role;
    private String enterprise;
    @Column(name="start_date", nullable = false)
    private LocalDateTime start;
    @Column(name="end_date")
    private LocalDateTime end;

    @Column(columnDefinition = "uuid")
    private UUID personid;

}
