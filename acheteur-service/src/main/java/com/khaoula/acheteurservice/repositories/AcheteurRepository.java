package com.khaoula.acheteurservice.repositories;

import com.khaoula.acheteurservice.entities.Acheteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController

public interface AcheteurRepository extends JpaRepository<Acheteur,Integer> {
}
