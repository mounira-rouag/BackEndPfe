package com.example.Project.Services;

import com.example.Project.Models.Marque;
import com.example.Project.Repositories.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MarqueServiceImpl {

    private final MarqueRepository marqueRepo;

    public MarqueServiceImpl(MarqueRepository marqueRepo) {
        this.marqueRepo = marqueRepo;
    }

    public List<Marque> getAllMarques() {
        return marqueRepo.findAll();
    }


}
