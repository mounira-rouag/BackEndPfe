package com.example.Project.Repositories;

import com.example.Project.Models.Maj;
import com.example.Project.Models.Marque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MajRepository extends JpaRepository<Maj, Integer> {

}
