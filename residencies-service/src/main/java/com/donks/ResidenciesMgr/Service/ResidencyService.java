package com.donks.ResidenciesMgr.Service;

import com.donks.ResidenciesMgr.Model.Residency;
import com.donks.ResidenciesMgr.Repository.ResidencyRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ResidencyService {

    @Autowired
    private final ResidencyRepository residencyRepository;

    public ResidencyService(ResidencyRepository residencyRepository) {
        this.residencyRepository = residencyRepository;
    }

    public List<Residency> findAll(){
        return residencyRepository.findAll();
    }

    public Residency addOne(Residency residency){
        Residency old = residencyRepository.findByPersonid(residency.getPersonid());
        if(old != null)
            residencyRepository.deleteById(old.getId());

        return residencyRepository.save(residency);
    }

    public Residency findById(UUID id){
        return residencyRepository.findById(id).orElse(null);
    }

    public Residency updateOne(@NotNull Residency residency){
        Optional<Residency> r = residencyRepository.findById(residency.getId());

        if(r.isEmpty()) return null;

        return residencyRepository.save(residency);
    }

    public Boolean deleteOne(UUID id){
        residencyRepository.deleteById(id);
        return residencyRepository.findById(id).isEmpty();
    }

    public Residency findByUserId(UUID userId){
        Residency residency = residencyRepository.findByPersonid(userId);
        return residency;
    }


}
