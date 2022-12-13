package com.donks.PeopleMgr.Service;

import com.donks.PeopleMgr.Model.JobRecord;
import com.donks.PeopleMgr.Model.People;
import com.donks.PeopleMgr.Model.Residency;
import com.donks.PeopleMgr.Repository.PeopleRepository;
import com.donks.PeopleMgr.feignclients.JobRecordFeignClient;
import com.donks.PeopleMgr.feignclients.ResidencyFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PeopleService {
    Logger logger = LoggerFactory.getLogger(PeopleService.class);

    @Autowired
    PeopleRepository peopleRepository;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ResidencyFeignClient residencyFeignClient;
    @Autowired
    JobRecordFeignClient jobRecordFeignClient;

    public People save(People people){
        return peopleRepository.save(people);
    }

    public List<People> getAll(){
        return peopleRepository.findAll();
    }

    public People getById(UUID id){
        return peopleRepository.findById(id).orElse(null);
    }

    /* JOB RECORD */

    public List<JobRecord> getAllJobs(){
        List<JobRecord> jobList = jobRecordFeignClient.findAll();
        return jobList;
    }
    public List<JobRecord> getPersonJobs(UUID idPerson){
//        List<JobRecord> jobsRecordList = restTemplate.getForObject("http://job-service/jobs/byuser/" + idPerson, List.class);
        Optional<List<JobRecord>> jobsRecordList = Optional.of(jobRecordFeignClient.findByPersonId(idPerson));

        if(jobsRecordList.isEmpty())
            return List.of();

        return jobsRecordList.get();
    }

    public JobRecord saveJobRecord(UUID idPerson, JobRecord jobRecord){
        jobRecord.setPersonid(idPerson);
        JobRecord newJob = jobRecordFeignClient.save(jobRecord);
        return newJob;
    }


    /* RESIDENCIES */

    public List<Residency> getAllResidencies(){
        List<Residency> residencyList = residencyFeignClient.findAll();
        return residencyList;
    }

    public Residency getPersonResidency(UUID idPerson){
        Residency residency = residencyFeignClient.findByPersonId(idPerson);
        return residency;
    }

    public Residency saveResidency(UUID idPerson, Residency residency){
        residency.setPersonid(idPerson);
        return residencyFeignClient.save(residency);
    }


    /* INFO */

    public Map<String,Object> getPersonInfo(UUID personId) {
        logger.info("Fetching INFO for Person Id {}",personId);
        Map<String, Object> info = new HashMap<>();
        People person = peopleRepository.findById(personId).orElse(null);

        if (person == null) {
            info.put("mensaje", "No existe la persona indicada");
            return info;
        }
        info.put("persona",person);

        Residency residency = getPersonResidency(personId);
        if(residency == null) {
            logger.info("No residencies found");
            info.put("residency", "No indicado");
        } else{

            info.put("Residency", residency);
        }


        List<JobRecord> jobs = getPersonJobs(personId);
        if(jobs.isEmpty()){
            logger.info("No jobs found");
            info.put("jobs", "No jobs found");
        }
        else{
            info.put("jobs",jobs);
        }

        return info;
    }
}
