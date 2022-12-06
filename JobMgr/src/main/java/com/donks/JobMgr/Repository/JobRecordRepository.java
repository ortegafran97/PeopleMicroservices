package com.donks.JobMgr.Repository;

import com.donks.JobMgr.Model.JobRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JobRecordRepository extends JpaRepository<JobRecord, UUID> {
    List<JobRecord> findByUserId(UUID userId);
}
