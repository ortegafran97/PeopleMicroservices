package com.donks.PeopleMgr.feignclients;

import com.donks.PeopleMgr.Model.Residency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "residencies-service", path = "/residencies")
public interface ResidencyFeignClient {
    @GetMapping
    List<Residency> findAll();
    @GetMapping("/byuser/{personId}")
    Residency findByPersonId(@PathVariable("personId") UUID personId);
    @PostMapping
    Residency save(Residency residency);
    @DeleteMapping("/{residencyId}")
    Boolean deleteById(@PathVariable UUID residencyId);
}
