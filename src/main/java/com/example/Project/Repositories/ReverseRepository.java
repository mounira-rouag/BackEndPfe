package com.example.Project.Repositories;

import com.example.Project.Models.Reverse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReverseRepository extends JpaRepository<Reverse,Integer> {
}
