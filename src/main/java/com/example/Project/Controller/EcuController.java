package com.example.Project.Controller;

import com.example.Project.Dto.Dto;
import com.example.Project.Models.Dev;
import com.example.Project.Models.Ecu;
import com.example.Project.Models.Sites;
import com.example.Project.Repositories.EcuRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/ecu")
public class EcuController {
    private final EcuRepository ecuRepo;

    public EcuController(EcuRepository ecuRepo) {
        this.ecuRepo = ecuRepo;
    }

    @PostMapping("/create")
    public Ecu createEcu(@RequestBody Ecu ecu){

        return ecuRepo.save(ecu);
    }

    @GetMapping("/all-ecu")
    public List<Ecu> findAllEcu(){
        return ecuRepo.findAll();
    }

    @GetMapping("/{id}")
    public Ecu getEcuById(@PathVariable int id){
        return ecuRepo.findById(id).get();
    }


}
