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

import com.lxs.cp.test.dto.MusicGenderDto;
import com.lxs.cp.test.service.MusicGenderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "music-gender", value = "MusicGenderController")
@RestController
@RequestMapping("/cp-test/api/music-gender")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class MusicGenderController {
	
	@Autowired
	MusicGenderService service;
	
	@ApiOperation(value = "Method to retrieve all music genders")
	@GetMapping("")
	public ResponseEntity<List<MusicGenderDto>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@ApiOperation(value = "Method to retrieve a music gender")
	@GetMapping("/{id}")
	public ResponseEntity<MusicGenderDto> findById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}

	@ApiOperation(value = "Method to retrieve a music gender")
	@PostMapping("")
	public ResponseEntity<MusicGenderDto> create(@RequestBody MusicGenderDto dto) {
		return new ResponseEntity<>(service.create(dto), HttpStatus.OK);
	}

	@ApiOperation(value = "Method to retrieve a music gender")
	@PutMapping("")
	public ResponseEntity<MusicGenderDto> update(@RequestBody MusicGenderDto dto) {
		return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
	}

	@ApiOperation(value = "Method to retrieve a music gender")
	@DeleteMapping("/{id}")
	public ResponseEntity<MusicGenderDto> delete(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}
}
