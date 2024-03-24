package com.example.Project.Repositories;

import com.example.Project.Models.TypeDev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeDevRepository extends JpaRepository <TypeDev,Integer> {
}
