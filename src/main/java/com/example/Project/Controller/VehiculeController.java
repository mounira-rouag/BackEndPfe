package com.example.Project.Controller;

import com.example.Project.Models.Dev;
import com.example.Project.Models.Marque;
import com.example.Project.Models.Vehicule;
import com.example.Project.Repositories.DevRepository;
import com.example.Project.Repositories.MarqueRepository;
import com.example.Project.Repositories.VehiculeRepository;
import com.example.Project.Services.VehiculeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/api/vehicule")
public class VehiculeController {


    private final VehiculeServiceImpl vehiculeServieImpl;
    private final MarqueRepository marqueRepo;

    final VehiculeRepository vehiculeRepository ;
    final private DevRepository devRepo;

    public VehiculeController(VehiculeRepository vehiculeRepo, VehiculeServiceImpl vehiculeServieImpl, MarqueRepository marqueRepo, VehiculeRepository vehiculeRepository, DevRepository devRepo) {

        this.vehiculeServieImpl = vehiculeServieImpl;
        this.marqueRepo = marqueRepo;
        this.vehiculeRepository = vehiculeRepository;
        this.devRepo = devRepo;
    }




    @GetMapping("/all")
    public  List<Vehicule> getAllVehicule(){
        return vehiculeRepository.findAll() ;
    }

    @PostMapping("/create")
    public  Vehicule saveVehicule(@RequestBody Vehicule vehicule){
        return vehiculeRepository.save(vehicule) ;
    }
    /**find vehicues by marque */
    @GetMapping("/by-marque/{marqueId}")
    public List<Vehicule> getVehiculesByMarque(@PathVariable int marqueId) {

        Marque marque = marqueRepo.getById(marqueId);
        return vehiculeServieImpl.getVehiculesByMarque(marque);
    }
    @GetMapping("/by-dev/{devId}")
    public List<Vehicule> getVehiculesByDevs(@PathVariable int devId) {

        Optional<Dev> dev=devRepo.findById(devId);

        if (dev.isPresent()) {

            Dev foundDev = dev.get();

            List<Vehicule> vehicles = dev.get().getVehicules();  // Need more context here
            return vehicles;
        } else {

            return Collections.emptyList();  // Or throw an appropriate exception
        }

    }
}
