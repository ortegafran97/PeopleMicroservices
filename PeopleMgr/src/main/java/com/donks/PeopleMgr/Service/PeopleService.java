package com.donks.PeopleMgr.Service;

import com.donks.PeopleMgr.Model.People;
import com.donks.PeopleMgr.Repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PeopleService {

    @Autowired
    PeopleRepository peopleRepository;

    public People save(People people){
        return peopleRepository.save(people);
    }

    public List<People> getAll(){
        return peopleRepository.findAll();
    }

    public People getById(UUID id){
        return peopleRepository.findById(id).orElse(null);
    }
}
