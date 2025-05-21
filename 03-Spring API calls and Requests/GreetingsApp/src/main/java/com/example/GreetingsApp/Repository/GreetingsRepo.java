package com.example.GreetingsApp.Repository;


import com.example.GreetingsApp.models.Greetings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  GreetingsRepo extends JpaRepository<Greetings,Long>{
    Optional<Greetings> findById(Long id);


}
