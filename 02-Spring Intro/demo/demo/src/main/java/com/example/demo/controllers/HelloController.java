package com.example.demo.controllers;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/")
public class HelloController {

        @GetMapping("/Hello")
        public String Hello(){
            return "Hello from SWETHA J";
        }
        @GetMapping("/query")
        public String printhelloquery(@RequestParam String name){
            return "hello "+ name ;

        }
        @GetMapping("/{name}")
        public String printhellopath(@PathVariable String name){
            return "hello new one"+name;

}
    }

