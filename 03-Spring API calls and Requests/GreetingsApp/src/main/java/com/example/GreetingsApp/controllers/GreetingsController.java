package com.example.GreetingsApp.controllers;

import com.example.GreetingsApp.models.Greetings;
import com.example.GreetingsApp.service.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/")
public class GreetingsController {
    @Autowired
    public GreetingsService service;

    @PostMapping("/add")
    public String add(@RequestBody Greetings e) {
        service.addGreeting(new Greetings(e.getId(), e.getFirstname(), e.getLastname()));
        return service.getGreeted(e);
    }

    @GetMapping("/getallGreetings")
    public List<String> getAllgreetings(){
    return service.getAllgreetings();
    }

    @GetMapping("/getAllDetails")
    public List<Greetings> getAlldetails(){
        return service.getAlldetails();
    }

    @PutMapping("/update/{id}")
    public String updateGreeting(@PathVariable long id,@RequestBody Greetings g){
      return service.update(id,new Greetings(
              g.getId(),g.getFirstname(),g.getLastname()
      ));
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id)
    {
         service.delete(id);
    }
}






