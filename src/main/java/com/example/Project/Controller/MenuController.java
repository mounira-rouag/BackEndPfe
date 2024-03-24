package com.example.Project.Controller;

import com.example.Project.Models.Menu;
import com.example.Project.Models.Reverse;
import com.example.Project.Models.TypeDev;
import com.example.Project.Repositories.MenuRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/menu")
public class MenuController {
    private final MenuRepository menuRepo;

    public MenuController(MenuRepository menuRepo) {
        this.menuRepo = menuRepo;
    }
    @PostMapping("creat")
    public Menu savemENU(@RequestBody Menu menu){

        return menuRepo.save(menu);
    }
    @GetMapping("/all")
    public List<Menu> getAllMenus() {
        return menuRepo.findAll();
    }


    @GetMapping("/{id}")
    public Menu finMenuById(@PathVariable int id){
        return menuRepo.findById(id).get();
    }


}