package com.donks.PeopleMgr.feignclients;

import com.donks.PeopleMgr.Model.JobRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "job-service",path = "/jobs")
public interface JobRecordFeignClient {

    @GetMapping
    List<JobRecord> findAll();
    @GetMapping("/byuser/{userId}")
    List<JobRecord> findByPersonId(@PathVariable("userId") UUID userId);
    @PostMapping
    JobRecord save(@RequestBody JobRecord jobRecord);
    @DeleteMapping("/{jobId}")
    Boolean deleteById(@PathVariable UUID jobId);
}
