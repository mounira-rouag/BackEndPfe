package com.example.Project.Controller;

import com.example.Project.Models.Ecu;
import com.example.Project.Models.EtatDev;
import com.example.Project.Models.Marque;
import com.example.Project.Models.Sites;
import com.example.Project.Repositories.EtatDevRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/etatdev")
public class EtatDevController {
    private final EtatDevRepository etatdevRepo;

    public EtatDevController(EtatDevRepository etatdevRepo) {
        this.etatdevRepo = etatdevRepo;
    }

    @PostMapping("/create")
    public EtatDev createEtatDev(@RequestBody EtatDev etatDev){

        return etatdevRepo.save(etatDev);
    }

    @GetMapping("/{id}")
    public EtatDev getEtatDevById(@PathVariable int id){
        return etatdevRepo.findById(id).get();
    }

    @GetMapping("/all")
    public List<EtatDev> getAllEtats() {
        return etatdevRepo.findAll();
    }

}
