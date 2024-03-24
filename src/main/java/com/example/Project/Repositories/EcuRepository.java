package com.example.Project.Repositories;

import com.example.Project.Models.Ecu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcuRepository extends JpaRepository<Ecu,Integer> {
}
