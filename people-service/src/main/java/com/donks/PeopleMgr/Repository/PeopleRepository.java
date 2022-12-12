package com.donks.PeopleMgr.Repository;

import com.donks.PeopleMgr.Model.People;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PeopleRepository extends JpaRepository<People, UUID> {
    Optional<People> findByDni(String dni);
}
