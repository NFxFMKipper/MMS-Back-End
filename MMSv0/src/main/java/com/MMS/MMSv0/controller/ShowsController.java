package com.MMS.MMSv0.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MMS.MMSv0.exception.ResourceNotFoundException;
import com.MMS.MMSv0.model.Shows;
import com.MMS.MMSv0.repository.ShowsRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ShowsController {
	
	@Autowired
	private ShowsRepository showsRepository;
	
	//get all shows
	@GetMapping("/shows")
	public List<Shows> getAllShows(){
		System.out.print(showsRepository.findAll());
		return showsRepository.findAll();
	}
	
	@GetMapping("/shows/{movieId}")
	public List<Shows> getShowsByMovie(@PathVariable int movieId) {
		return showsRepository.findByMovieId(movieId);
	}
	
	@GetMapping("/dates/{movieId}")
	public List<Date> getDatesByMovie(@PathVariable int movieId) {
		List<Shows> list = showsRepository.findByMovieId(movieId);
		List<Date> resDates = new ArrayList<>();
		resDates.clear();
		HashSet<Date> dates = new HashSet<Date>();
		dates.clear();
		for(Shows show: list)
			dates.add(show.getShowDay());
		for(Date date: dates)
			resDates.add(date);
		Collections.sort(resDates);
		return resDates;
	}
	
	@GetMapping("/shows/{movieId}/{showDay}")
	public List<Time> getTimeByMovieAndDate(@PathVariable int movieId, @PathVariable Date showDay) {
		List<Shows> list = showsRepository.findByMovieIdAndShowDay(movieId, showDay);
		List<Time> resTimes = new ArrayList<>();
		resTimes.clear();
		HashSet<Time> times = new HashSet<Time>();
		times.clear();
		for(Shows show: list)
			times.add(show.getStartTime());
		for(Time time: times)
			resTimes.add(time);
		Collections.sort(resTimes);
		return resTimes;
	}
}
