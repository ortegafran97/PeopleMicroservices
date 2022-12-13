package com.donks.PeopleMgr.Controller;

import com.donks.PeopleMgr.Model.JobRecord;
import com.donks.PeopleMgr.Model.People;
import com.donks.PeopleMgr.Model.Residency;
import com.donks.PeopleMgr.Service.PeopleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/people")
public class PeopleController {
    Logger logger = LoggerFactory.getLogger(PeopleController.class);
    @Autowired
    PeopleService peopleService;

    /* PEOPLE */

    @GetMapping
    public ResponseEntity<List<People>> getAll(){
        return ResponseEntity.ok(peopleService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<People> getById(@PathVariable("id") UUID id){
        People search = peopleService.getById(id);

        if(search == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(search);
    }

    @PostMapping
    public ResponseEntity<People> save(@RequestBody People people){
        People peopleNew = peopleService.save(people);
        if(peopleNew == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(peopleNew);
    }

    /* RESIDENCIES */

    @GetMapping("/residency/byuser/{personId}")
    public ResponseEntity<Residency> getResidency(@PathVariable("personId") UUID personId){
        People people = peopleService.getById(personId);

        if(people == null) return ResponseEntity.notFound().build();

        Residency residency = peopleService.getPersonResidency(personId);
        return ResponseEntity.ok(residency);
    }

    @GetMapping("/residency/all")
    public ResponseEntity<List<Residency>> getAllResidencies(){
        return ResponseEntity.ok(peopleService.getAllResidencies());
    }

    @PostMapping("/residency/{idPerson}")
    public ResponseEntity<Residency> saveResidency(@PathVariable("idPerson") UUID idPerson, @RequestBody Residency residency){
        logger.info("Saving new residency for PersonId {}",idPerson);
        People person = peopleService.getById(idPerson);
        if(person == null)
            return ResponseEntity.notFound().build();

        Residency newResidency = peopleService.saveResidency(idPerson, residency);
        if(newResidency == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(newResidency);
    }

    /* JOBS */

    @GetMapping("/jobs/all")
    public ResponseEntity<List<JobRecord>> getAllJobs(){
        return ResponseEntity.ok(peopleService.getAllJobs());
    }

    @GetMapping("/jobs/byuser/{personId}")
    public ResponseEntity<List<JobRecord>> getJobs(@PathVariable("personId") UUID personId){
        People people = peopleService.getById(personId);

        if(people == null) return ResponseEntity.noContent().build();

        List<JobRecord> jobRecordList = peopleService.getPersonJobs(personId);


        return ResponseEntity.ok(jobRecordList);
    }

    @PostMapping("/jobs/{idPerson}")
    public ResponseEntity<JobRecord> saveJob(@PathVariable("idPerson") UUID idPerson,@RequestBody JobRecord jobRecord){
        People person = peopleService.getById(idPerson);
        if(person == null)
            return ResponseEntity.notFound().build();

        JobRecord newJob = peopleService.saveJobRecord(idPerson, jobRecord);
        if(newJob == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(newJob);
    }

    @GetMapping("/info/{idPerson}")
    public ResponseEntity<Map<String,Object>> getInfoByPersonId(@PathVariable("idPerson") UUID idPerson){
        logger.info("Fetching info for PersonId {}",idPerson);
        return ResponseEntity.ok(peopleService.getPersonInfo(idPerson));
    }



}
