package com.lxs.cp.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lxs.cp.test.dto.GenreDto;
import com.lxs.cp.test.service.GenreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "music-genre", value = "GenreController")
@RestController
@RequestMapping("/cp-test/api/music-genre")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class GenreController {
	
	@Autowired
	GenreService service;
	
	@ApiOperation(value = "Method to retrieve all music genres")
	@GetMapping("")
	public ResponseEntity<List<GenreDto>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@ApiOperation(value = "Method to retrieve a music genre")
	@GetMapping("/{id}")
	public ResponseEntity<GenreDto> findById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}

	@ApiOperation(value = "Method to retrieve a music genre")
	@PostMapping("")
	public ResponseEntity<GenreDto> create(@RequestBody GenreDto dto) {
		return new ResponseEntity<>(service.create(dto), HttpStatus.OK);
	}

	@ApiOperation(value = "Method to retrieve a music genre")
	@PutMapping("")
	public ResponseEntity<GenreDto> update(@RequestBody GenreDto dto) {
		return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
	}

	@ApiOperation(value = "Method to retrieve a music genre")
	@DeleteMapping("/{id}")
	public ResponseEntity<GenreDto> delete(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}
}
