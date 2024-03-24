package com.example.Project.Controller;

import com.example.Project.Models.Dev;
import com.example.Project.Models.Marque;
import com.example.Project.Models.Menu;
import com.example.Project.Repositories.MarqueRepository;
import com.example.Project.Services.MarqueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/marques")
public class MarqueController {

    private final MarqueServiceImpl marqueService;
    private final MarqueRepository marqueRepo;

    public MarqueController(MarqueServiceImpl marqueService, MarqueRepository marqueRepo) {
        this.marqueService = marqueService;
        this.marqueRepo = marqueRepo;
    }
@GetMapping("/all-marques")
    public List<Marque> getAllMarqueNames() {
        return marqueService.getAllMarques();
    }


    @PostMapping("/create")
    public Marque createMarque(@RequestBody Marque marque){

        return marqueRepo.save(marque);
    }

    @PutMapping("/update/{id}")
    public Marque updateMarque(@PathVariable int id, @RequestBody Marque updatedMarque) {
        // Set the ID of the updated Marque
        updatedMarque.setIdMarque(id);
        return marqueRepo.save(updatedMarque);
    }
    @GetMapping("/all")
    public List<Marque> getAllMenus() {
        return marqueRepo.findAll();
    }

    @GetMapping("/{id}")
    public Marque finMarqueById(@PathVariable int id){
        return marqueRepo.findById(id).get();
    }

}
