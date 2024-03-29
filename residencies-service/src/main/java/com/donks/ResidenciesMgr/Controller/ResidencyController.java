package com.donks.ResidenciesMgr.Controller;

import com.donks.ResidenciesMgr.Model.Residency;
import com.donks.ResidenciesMgr.Service.ResidencyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/residencies")
public class ResidencyController {
    Logger logger = LoggerFactory.getLogger(ResidencyController.class);

    @Autowired
    private final ResidencyService residencyService;

    public ResidencyController(ResidencyService residencyService) {
        this.residencyService = residencyService;
    }

    @GetMapping
    public ResponseEntity<List<Residency>> findAll(){
        logger.info("GET ALL residencies");
        return ResponseEntity.ok(residencyService.findAll());
    }

    @GetMapping(value = "/{residencyId}")
    public ResponseEntity<Residency> findOne(@PathVariable("residencyId")UUID residencyId){
        Optional<Residency> residency = Optional.of(residencyService.findById(residencyId));

        return residency.isEmpty()?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(residency.get());
    }

    @GetMapping("/byuser/{userId}")
    public ResponseEntity<Residency> findByUserId(@PathVariable("userId")UUID userId){
        Residency residency = residencyService.findByUserId(userId);

        if(residency == null)
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(residency);
    }

    @PostMapping
    public ResponseEntity<Residency> saveOne(@RequestBody Residency residency){
        Residency residencyNew = residencyService.addOne(residency);
        if(residencyNew == null)
            return ResponseEntity.internalServerError().build();

        return ResponseEntity.ok(residencyNew);
    }

    @DeleteMapping(value = "/{residencyId}")
    public ResponseEntity<Boolean> deleteOne(@PathVariable("residencyId")UUID id){
        return residencyService.deleteOne(id) ?
                ResponseEntity.ok(true) :
                ResponseEntity.notFound().build();

    }





}
