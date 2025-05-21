package com.example.GreetingsApp.service;

import com.example.GreetingsApp.Repository.GreetingsRepo;
import com.example.GreetingsApp.models.Greetings;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GreetingsService {
    @Autowired
    public GreetingsRepo repo;

    public void addGreeting(Greetings g){
        repo.save(g);
    }
    public String getGreeted(Greetings g){
        return "Hello" + g.getFirstname() + " "+g.getLastname();
    }

    public List<Greetings> getAlldetails()
    {
        return repo.findAll();
    }
  public List<String> getAllgreetings(){
        return repo.findAll().stream().map(
                user -> ("Hello " +" "
                        + user.getFirstname()+" "
                        +user.getLastname()))
                .collect(Collectors.toList());

  }
  public String update(long id,Greetings g){
        return repo.findById(id).map(
                u ->{
                    u.setId(g.getId());
                    u.setFirstname(g.getFirstname());
                    u.setLastname(g.getLastname());
                    repo.save(u);
                    return "Hello "+" "+u.getFirstname()+" "+u.getLastname();
                }
        ).orElseThrow();
  }
  public void delete(long id){
        repo.deleteById(id);
  }




}
