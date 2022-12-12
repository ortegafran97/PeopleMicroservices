package com.donks.PeopleMgr.Controller;

import com.donks.PeopleMgr.Model.People;
import com.donks.PeopleMgr.Service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    PeopleService peopleService;

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
        if(peopleNew.equals(null))
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(peopleNew);
    }

}
