package com.example.Project.Controller;

import com.example.Project.Models.CDC;
import com.example.Project.Models.Reverse;
import com.example.Project.Models.Sites;
import com.example.Project.Models.TypeDev;
import com.example.Project.Repositories.ReverseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")

@RestController
@RequestMapping("/api/reverse")
public class ReverseController {
private final ReverseRepository reverseRepo;

    public ReverseController(ReverseRepository reverseRepo) {
        this.reverseRepo = reverseRepo;
    }

    @PostMapping("cretae")
    public Reverse saveReverse(@RequestBody Reverse reverse){
        return reverseRepo.save(reverse);
    }

    @GetMapping("/all")
    public List<Reverse> getAllReverses() {
        return reverseRepo.findAll();
    }

    @GetMapping("/{id}")
    public Reverse finRverseById(@PathVariable int id){
        return reverseRepo.findById(id).get();
    }

}
