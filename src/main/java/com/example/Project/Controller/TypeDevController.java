package com.example.Project.Controller;

import com.example.Project.Models.Reverse;
import com.example.Project.Models.TypeDev;
import com.example.Project.Repositories.TypeDevRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/dev-type")
public class TypeDevController {
    private final TypeDevRepository typeDevRepo;

    public TypeDevController(TypeDevRepository typeDevRepo) {
        this.typeDevRepo = typeDevRepo;
    }
    @PostMapping("/cretae")
    public TypeDev saveTypeDev(@RequestBody TypeDev typeDev){

        return typeDevRepo.save(typeDev);
    }
    @GetMapping
    public List<TypeDev> getAllTypeDevs(){
        return typeDevRepo.findAll();
    }
    @GetMapping("/{id}")
    public TypeDev finTypeDevById(@PathVariable int id){
        return typeDevRepo.findById(id).get();
    }

}
