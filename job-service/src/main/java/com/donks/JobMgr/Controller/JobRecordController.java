package com.donks.JobMgr.Controller;

import com.donks.JobMgr.Model.JobRecord;
import com.donks.JobMgr.Service.JobRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/jobs")
public class JobRecordController {

    private final JobRecordService jobRecordService;

    public JobRecordController(JobRecordService jobRecordService) {
        this.jobRecordService = jobRecordService;
    }

    @PostMapping
    public ResponseEntity<JobRecord> saveOne(@RequestBody JobRecord jobRecord){
        return ResponseEntity.ok(jobRecordService.saveOne(jobRecord));
    }

    @GetMapping
    public ResponseEntity<List<JobRecord>> findAll(){
        return ResponseEntity.ok(jobRecordService.findAll());
    }

    @GetMapping(value = "/{jobId}")
    public ResponseEntity<JobRecord> findById(@PathVariable("jobId")UUID jobId){
        return ResponseEntity.ok(jobRecordService.findById(jobId));
    }

    @GetMapping(value = "/byuser/{personId}")
    public ResponseEntity<List<JobRecord>> findByUser(@PathVariable UUID personId){
        List<JobRecord> list = jobRecordService.findByUserId(personId);
        if(list == null)
            return ResponseEntity.ok(List.of());

        return ResponseEntity.ok(list);
    }

    @DeleteMapping(value = "/{jobId}")
    public ResponseEntity<Boolean> deleteOne(@PathVariable("jobId")UUID jobId){
        if(jobRecordService.findById(jobId)== null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(jobRecordService.deleteOne(jobId));
    }
}
