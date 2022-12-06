package com.donks.PeopleMgr.PeopleServiceTests;

import com.donks.PeopleMgr.Repository.PeopleRepository;
import com.donks.PeopleMgr.Service.PeopleService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

public class PeopleServiceShould {

    PeopleService peopleService;

    @BeforeEach
    public void setUp(){
        PeopleRepository peopleRepository = Mockito.mock(PeopleRepository.class);
        peopleService = new PeopleService(peopleRepository);
    }


}
