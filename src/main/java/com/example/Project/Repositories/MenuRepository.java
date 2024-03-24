package com.example.Project.Repositories;

import com.example.Project.Models.Marque;
import com.example.Project.Models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
}
