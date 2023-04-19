package com.donks.ResidenciesMgr.FeignClient;

import com.donks.ResidenciesMgr.Model.People;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@FeignClient(name="people-service", path="/people")
public interface PeopleFeignClient {

    @GetMapping
    List<People> findAll();

    @GetMapping("/{id}")
    Optional<People> findById(@PathVariable("id") UUID id);
}
