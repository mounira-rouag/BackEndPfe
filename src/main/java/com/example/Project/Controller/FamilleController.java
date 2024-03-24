package com.example.Project.Controller;

import com.example.Project.Models.Famille;
import com.example.Project.Repositories.FamilleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")

@RestController
@RequestMapping("/api")
public class FamilleController {
private final FamilleRepository famillRepo;

    public FamilleController(FamilleRepository famillRepo) {
        this.famillRepo = famillRepo;
    }

    @GetMapping
    public List<Famille> getAllFamilles() {

        return famillRepo.findAll() ;
    }

    @GetMapping("/{id}")
    public Famille getFamilleById(@PathVariable int id) {

        return famillRepo.findById(id).get();
    }

    @PostMapping
    public Famille createFamille(@RequestBody Famille famille) {
        return famillRepo.save(famille);
    }



    @DeleteMapping("/{id}")
    public Void deleteFamille(@PathVariable int id) {

        famillRepo.deleteById(id);
        return null;
    }
}
