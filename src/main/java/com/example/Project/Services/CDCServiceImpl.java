package com.example.Project.Services;

import com.example.Project.Models.CDC;
import com.example.Project.Models.Dev;
import com.example.Project.Repositories.CDCRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CDCServiceImpl {
    private final CDCRepository cdcRepo;

    public CDCServiceImpl(CDCRepository cdcRepo) {
        this.cdcRepo = cdcRepo;
    }

    public Optional<CDC> findById(int id) {
        return cdcRepo.findById(id);
    }

    public List<Dev> findDevByCdc(CDC cdc){
        return cdc.getDev();
    }
}
