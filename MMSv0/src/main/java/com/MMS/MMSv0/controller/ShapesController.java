package com.MMS.MMSv0.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MMS.MMSv0.model.Shapes;
import com.MMS.MMSv0.repository.ShapesRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ShapesController {

	@Autowired
	private ShapesRepository shapesRepository;
	
	//get all rows
	@GetMapping("/shapes")
	public List<Shapes> getAllScreenRows(){
		if(shapesRepository.findAll() == null)
			System.out.print(shapesRepository.findAll());
		System.out.print(shapesRepository.findAll());
		return shapesRepository.findAll();
	}
}
