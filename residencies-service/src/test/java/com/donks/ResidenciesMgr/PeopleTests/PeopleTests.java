package com.donks.ResidenciesMgr.PeopleTests;

import com.donks.ResidenciesMgr.FeignClient.PeopleFeignClient;
import com.donks.ResidenciesMgr.Model.People;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PeopleTests {

    @Autowired
    PeopleFeignClient peopleFeignClient;

    public void setUp(){

    }

    @Test
    public void findPeople(){
        List<People> list = peopleFeignClient.findAll();

        assertNotNull(list);

    }
}
