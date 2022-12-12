package com.donks.ResidenciesMgr.Controller;

import com.donks.ResidenciesMgr.Model.Residency;
import com.donks.ResidenciesMgr.Service.ResidencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/residency")
public class ResidencyController {

    @Autowired
    private final ResidencyService residencyService;

    public ResidencyController(ResidencyService residencyService) {
        this.residencyService = residencyService;
    }

    @GetMapping
    public ResponseEntity<List<Residency>> findAll(){
        return ResponseEntity.ok(residencyService.findAll());
    }

    @GetMapping(value = "/{residencyId}")
    public ResponseEntity<Residency> findOne(@PathVariable("residencyId")UUID residencyId){
        Optional<Residency> residency = Optional.of(residencyService.findById(residencyId));

        return residency.isEmpty()?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(residency.get());
    }

    @GetMapping(value ="/byUser/{userId}")
    public ResponseEntity<List<Residency>> findByUserId(@PathVariable("userId")UUID userId){
        List<Residency> residencies = residencyService.findByUserId(userId);
        return ResponseEntity.ok(residencies);
    }

    @PostMapping
    public ResponseEntity<Residency> saveOne(@RequestBody Residency residency){

        Residency residencyNew = residencyService.addOne(residency);

        if(residencyNew.equals(null))
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
