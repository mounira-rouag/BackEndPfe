package com.example.Project.Repositories;

import com.example.Project.Models.CDC;
import com.example.Project.Models.Fonction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FonctionRpository extends JpaRepository<Fonction,Integer> {


    List<Fonction> getFonctionsByCdc(CDC cdc);
}
