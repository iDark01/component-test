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

import com.lxs.cp.test.dto.SubGenreDto;
import com.lxs.cp.test.service.SubGenreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "music-subgenre", value = "SubGenreController")
@RestController
@RequestMapping("/cp-test/api/music-subgenre")
//@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class SubGenreController {
	
	@Autowired
	SubGenreService service;
	
	@ApiOperation(value = "Method to retrieve all music subgenres")
	@GetMapping("")
	public ResponseEntity<List<SubGenreDto>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@ApiOperation(value = "Method to retrieve a music subgenre")
	@GetMapping("/{id}")
	public ResponseEntity<SubGenreDto> findById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}

	@ApiOperation(value = "Method to retrieve a music subgenre")
	@PostMapping("")
	public ResponseEntity<SubGenreDto> create(@RequestBody SubGenreDto dto) {
		return new ResponseEntity<>(service.create(dto), HttpStatus.OK);
	}

	@ApiOperation(value = "Method to retrieve a music subgenre")
	@PutMapping("")
	public ResponseEntity<SubGenreDto> update(@RequestBody SubGenreDto dto) {
		return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
	}

	@ApiOperation(value = "Method to retrieve a music subgenre")
	@DeleteMapping("/{id}")
	public ResponseEntity<SubGenreDto> delete(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}
}
