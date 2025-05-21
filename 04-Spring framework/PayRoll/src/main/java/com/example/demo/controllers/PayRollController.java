package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.PayRollmodel;
import com.example.demo.service.PayRollservice;

@RestController
@RequestMapping("/")

public class PayRollController {
	@Autowired
	private PayRollservice service;
	 
	@PostMapping("/add")
	public void createEmp(@RequestBody PayRollmodel p)
	{
		service.addemp(new PayRollmodel(p.getSalary(),p.getName()));
	}
	@GetMapping("/getalldetails")
	public List<PayRollmodel> getalldetails()
	{
		return service.getalldetails();
	}
	@GetMapping("/{id}")
	public PayRollmodel getbyid(@PathVariable long id)
	{
		return service.getbyid(id);
		
	}
	
	@PutMapping("/update/{id}")
	public String update(@PathVariable long id ,@RequestBody PayRollmodel p)
	{
		return service.update(id,
				(new PayRollmodel(p.getSalary(),p.getName())));
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id)
	{
		service.delete(id);
	}

}
