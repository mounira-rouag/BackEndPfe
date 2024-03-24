package com.example.Project.Services;

import com.example.Project.Models.Famille;
import com.example.Project.Models.Marque;
import com.example.Project.Repositories.FamilleRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class FamilleServiceImpl {
private final FamilleRepository familleRepo;

    public FamilleServiceImpl(FamilleRepository familleRepo) {
        this.familleRepo = familleRepo;
    }

    @PostMapping("/create")
    public Famille createMarque(@RequestBody Famille famille){

        return familleRepo.save(famille);
    }
}
