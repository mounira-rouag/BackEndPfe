package com.example.Project.Controller;

import com.example.Project.Models.CDC;
import com.example.Project.Models.Ecu;
import com.example.Project.Repositories.CDCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RequestMapping("/cdc")
@RestController
public class CdcController {

    final CDCRepository cdcRepository;

    public CdcController(CDCRepository cdcRepository) {
        this.cdcRepository = cdcRepository;
    }

    @GetMapping("/all")
    public List<CDC> getAllCdc() {
        return cdcRepository.findAll();
    }

    @PostMapping("cretae")
    public CDC saveCdc(@RequestBody CDC cdc){
        return cdcRepository.save(cdc);
    }

    @GetMapping("/{id}")
    public CDC getCdcById(@PathVariable int id){
        return cdcRepository.findById(id).get();
    }
}
