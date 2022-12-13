package com.donks.JobMgr.Service;

import com.donks.JobMgr.Model.JobRecord;
import com.donks.JobMgr.Repository.JobRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class JobRecordService {

    private final JobRecordRepository jobRecordRepository;

    public JobRecordService(JobRecordRepository jobRecordRepository) {
        this.jobRecordRepository = jobRecordRepository;
    }

    public JobRecord findById(UUID jobId){
        return jobRecordRepository.findById(jobId).orElse(null);
    }

    public List<JobRecord> findAll(){
        return jobRecordRepository.findAll();
    }

    public List<JobRecord> findByUserId(UUID userId){
        return jobRecordRepository.findByPersonid(userId);
    }

    public Boolean deleteOne(UUID jobId){
        jobRecordRepository.deleteById(jobId);
        return jobRecordRepository.findById(jobId).isEmpty();
    }

    public JobRecord saveOne(JobRecord jobRecord){
        return jobRecordRepository.save(jobRecord);
    }
}
