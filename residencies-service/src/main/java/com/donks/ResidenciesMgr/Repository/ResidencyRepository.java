package com.donks.ResidenciesMgr.Repository;

import com.donks.ResidenciesMgr.Model.Residency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ResidencyRepository extends JpaRepository<Residency, UUID> {
    List<Residency> findByUserId(UUID userId);

}
