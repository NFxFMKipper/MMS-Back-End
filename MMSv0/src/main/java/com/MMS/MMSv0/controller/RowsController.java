package com.MMS.MMSv0.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MMS.MMSv0.model.Rows;
import com.MMS.MMSv0.repository.RowsRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class RowsController {

	@Autowired
	private RowsRepository rowsRepository;
	
	//get all rows
	@GetMapping("/rows")
	public List<Rows> getAllCustomers(){
		if(rowsRepository.findAll() == null)
			System.out.print(rowsRepository.findAll());
		System.out.print(rowsRepository.findAll());
		return rowsRepository.findAll();
	}
}
