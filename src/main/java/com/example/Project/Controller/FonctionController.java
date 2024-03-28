package com.example.Project.Controller;

import com.example.Project.Models.CDC;
import com.example.Project.Models.Dev;
import com.example.Project.Models.Fonction;
import com.example.Project.Models.Vehicule;
import com.example.Project.Repositories.CDCRepository;
import com.example.Project.Repositories.FonctionRpository;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/fonction")
public class FonctionController {

    private final FonctionRpository fonctionRepo;
    private final CDCRepository cdcRepo;

    public FonctionController(FonctionRpository fonctionRepo, CDCRepository cdcRepo) {
        this.fonctionRepo = fonctionRepo;
        this.cdcRepo = cdcRepo;
    }

    @GetMapping("/all")
    public List<Fonction> getAllFonctions() {
        return fonctionRepo.findAll();
    }

    @PostMapping("create")
    public Fonction saveFonction(@RequestBody Fonction fonction){
        return fonctionRepo.save(fonction);
    }

    @GetMapping("/{id}")
    public Fonction getFonctionById(@PathVariable int id){
        return fonctionRepo.findById(id).get();
    }



    @GetMapping("/by-cdc/{cdcId}")
    public List<Fonction> getFonctionsByCDC(@PathVariable int cdcId) {

        Optional<CDC> Cdc=cdcRepo.findById(cdcId);

        if (Cdc.isPresent()) {

            CDC foundCDC = Cdc.get();

            List<Fonction> fonctions = Cdc.get().getFonctions();  // Need more context here
            return fonctions;
        } else {

            return Collections.emptyList();  // Or throw an appropriate exception
        }

    }
}
