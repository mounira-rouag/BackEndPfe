package com.example.Project.Services;

import com.example.Project.Models.Dev;
import com.example.Project.Models.Marque;
import com.example.Project.Models.Vehicule;
import com.example.Project.Repositories.VehiculeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculeServiceImpl {
    private final VehiculeRepository vehiculeRepo;

    public VehiculeServiceImpl(VehiculeRepository vehiculeRepo) {
        this.vehiculeRepo = vehiculeRepo;
    }

    public List<Vehicule> getVehiculesByMarque(Marque marque) {
        return vehiculeRepo.findByMarque(marque);
    }

    public List<Vehicule> getVehiculeByDev(Dev dev){
        return vehiculeRepo.findBydevs(dev);
    }
}
