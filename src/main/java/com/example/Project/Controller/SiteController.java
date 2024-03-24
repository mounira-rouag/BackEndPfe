package com.example.Project.Controller;


import com.example.Project.Models.CDC;
import com.example.Project.Models.Sites;
import com.example.Project.Repositories.SitesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RequestMapping("api/sites")
@RestController
public class SiteController {

    final SitesRepository sitesRepository;

    public SiteController(SitesRepository sitesRepository) {
        this.sitesRepository = sitesRepository;
    }

    @GetMapping("/all")
    public List<Sites> getAllSites() {
        return sitesRepository.findAll();
    }

    @PostMapping("/save")
    public Sites saveSite(@RequestBody Sites sites){
        return sitesRepository.save(sites);
    }

    @DeleteMapping("/delete")
    public void deletSite(@PathVariable int id){
       sitesRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Sites getSiteById(@PathVariable int id){
       return sitesRepository.findById(id).get();
    }

}
