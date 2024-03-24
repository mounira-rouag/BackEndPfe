package com.example.Project.Repositories;

import com.example.Project.Models.Marque;
import com.example.Project.Models.Sites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SitesRepository extends JpaRepository<Sites, Integer> {
  Optional<Sites> findById(int id);
}
