package com.MMS.MMSv0.controller;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MMS.MMSv0.exception.ResourceNotFoundException;
import com.MMS.MMSv0.model.Movie;
import com.MMS.MMSv0.repository.MovieRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;
	
	//get all movies
	@GetMapping("/movies")
	public List<Movie> getAllMovies(){
		return movieRepository.findAll();
	}
	
	//get image
	@GetMapping("/movies/{Id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable int Id){
        // Load file as Resource
		Movie movie  = movieRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Movie does not exist"));

        return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType("image/jpeg"))
            .header("attachment; filename=\"" + movie.getMovieName() + "\"")
            .body(new ByteArrayResource(movie.getPoster()));
    }
}
