package com.example.Project.Services;

import com.example.Project.Dto.Dto;
import com.example.Project.Models.Dev;
import com.example.Project.Models.Maj;
import com.example.Project.Models.Marque;
import com.example.Project.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DevServiceImpl {
    private final DevRepository devRepo;
    private final CDCRepository cdcRepository;
    @Autowired
    private EcuRepository ecuRepository;

    @Autowired
    private MajRepository majRepository;

    @Autowired
    private EtatDevRepository etatDevRepository;

    @Autowired
    private UserInterface userRepository;

    public Dev CreatDev(Dto dtocraetion){
    Dev dev =new Dev();

        // Map fields from DevDTO to Dev
        dev.setDevname(dtocraetion.getDevname());
        dev.setDll(dtocraetion.getDll());
        dev.setDevDuplique(dtocraetion.isDevDuplique());
        dev.setDevComment(dtocraetion.getDevComment());
        dev.setNumBug(dtocraetion.getNumBug());

        dev.setCdc(cdcRepository.findById(dtocraetion.getIdCDC()).orElse(null));
        dev.setEcu(ecuRepository.findById(dtocraetion.getIdEcu()).orElse(null));
        dev.setMaj(majRepository.findById(dtocraetion.getIdMaj()).orElse(null));


        dev.setEtatdev(etatDevRepository.findById(dtocraetion.getIdEtatDev()).orElse(null));
       // dev.setUser(userRepository.findById(dtocraetion.getIdRC()).orElse(null));

        // Set other properties as needed

        // Save the Dev object
        return devRepo.save(dev);

    }

    public DevServiceImpl(DevRepository devRepo, CDCRepository cdcRepository) {
        this.devRepo = devRepo;
        this.cdcRepository = cdcRepository;
    }

    public List<Dev> getAllDev() {
        return devRepo.findAll();
    }

    public Dev saveDev(Dev dev) {
        return devRepo.save(dev);
    }

    public Optional<Dev> findById(int id) {
        return devRepo.findById(id);
    }

    public List<Dev> getDevByCdcId(int id) {
        return devRepo.findByCDC(id);
    }
   public List<Dev> getDevByMaj(Maj maj){
        return devRepo.findByMaj(maj);
   }


}
