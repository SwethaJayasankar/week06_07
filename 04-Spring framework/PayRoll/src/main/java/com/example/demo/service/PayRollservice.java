package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.PayRollRepository;
import com.example.demo.models.PayRollmodel;

@Service
public class PayRollservice {
	
	@Autowired
	private PayRollRepository repo;
	
	public void addemp(PayRollmodel emp)
	{
		repo.save(emp);
	}
	
	public List<PayRollmodel> getalldetails()
	{
		return repo.findAll();
	}
	
	public PayRollmodel getbyid(long id)
	{
		return repo.findById(id).orElseThrow();
	}
	
	public String update(long id,PayRollmodel p)
	{
		return repo.findById(id)
			.map(u ->
			{ 
			u.setName(p.getName());
			u.setSalary(p.getSalary());
			repo.save(u);
			return u.getId()+" "+u.getName()+" "+u.getSalary();
			
			}).orElseThrow();
			
	}
	
	public void delete(long id)
	{
		repo.deleteById(id);
	}
}
	

