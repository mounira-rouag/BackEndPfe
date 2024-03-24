package com.example.Project.Repositories;

import com.example.Project.Models.EtatDev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatDevRepository extends JpaRepository<EtatDev,Integer> {
}
