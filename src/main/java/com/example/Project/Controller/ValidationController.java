package com.example.Project.Controller;

import com.example.Project.Models.CDC;
import com.example.Project.Models.Dev;
import com.example.Project.Models.Fonction;
import com.example.Project.Models.Validation;
import com.example.Project.Repositories.CDCRepository;
import com.example.Project.Repositories.DevRepository;
import com.example.Project.Repositories.FonctionRpository;
import com.example.Project.Repositories.ValidationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/validation")
public class ValidationController {

    private final ValidationRepository validationRepo;
    private final DevRepository devRepo;

    public ValidationController(ValidationRepository validationRepo, DevRepository devRepo) {
        this.validationRepo = validationRepo;
        this.devRepo = devRepo;
    }


    @GetMapping("/all")
    public List<Validation> getAllValidations() {
        return validationRepo.findAll();
    }

    @PostMapping("create")
    public Validation saveValidation(@RequestBody Validation validation){
        return validationRepo.save(validation);
    }

    @GetMapping("/{id}")
    public Validation getValidationById(@PathVariable int id){
        return validationRepo.findById(id).get();
    }



    @GetMapping("/by-dev/{iddev}")
    public List<Validation> getValidationByDev(@PathVariable int iddev) {

        Optional<Dev> dev=devRepo.findById(iddev);

        if (dev.isPresent()) {

            Dev foundDEv = dev.get();

            List<Validation> fonctions = dev.get().getValidations();
            return fonctions;
        } else {

            return Collections.emptyList();
        }

    }
}
