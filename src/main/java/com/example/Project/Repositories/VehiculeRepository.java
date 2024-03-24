package com.example.Project.Repositories;

import com.example.Project.Models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculeRepository  extends JpaRepository<Vehicule, IdVeh> {
    List<Vehicule> findByMarque(Marque marque);
    Vehicule findByCodeVeh(int codeveh);
    List<Vehicule> findBydevs(Dev dev);

}

