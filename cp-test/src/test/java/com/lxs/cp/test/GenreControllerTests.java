package com.lxs.cp.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.lxs.cp.test.constants.ValueConstants;
import com.lxs.cp.test.controller.GenreController;
import com.lxs.cp.test.dto.GenreDto;
import com.lxs.cp.test.entity.GenreEntity;
import com.lxs.cp.test.repository.GenreRepository;
import com.lxs.cp.test.service.GenreService;

@RunWith(MockitoJUnitRunner.class)
public class GenreControllerTests {
	
	private static final Long ID = 1L;
	
	 @Spy
	 GenreRepository repository;
	 
	 @Spy
	 @InjectMocks
	 GenreService service;
	 
	 @InjectMocks
	 GenreController controller = new GenreController();
	 
	 public GenreDto dummyDto() {
		 return GenreDto.builder()
				 .id(1L)
				 .name("")
				 .description("")
				 .enable(ValueConstants.ENABLED)
				 .build();
	 }
	 
	 public GenreEntity dummyEntity() {
		 return GenreEntity.builder()
				 .id(1L)
				 .name("")
				 .description("")
				 .enable(ValueConstants.ENABLED)
				 .build();
	 }
	 
	 public List<GenreEntity> dummyList() {
		 return Collections.singletonList(dummyEntity());
	 }
	 
	 @Before
	 public void init() {
		 MockitoAnnotations.initMocks(this);
		 when(repository.findAll()).thenReturn(dummyList());
		 when(repository.findById(ID)).thenReturn(Optional.of(dummyEntity()));
		 when(repository.save(any(GenreEntity.class))).thenReturn(dummyEntity());
	 }
	 
	 @Test
	 public void findAll() {
		 ResponseEntity<List<GenreDto>> response = controller.findAll();
		 assertNotNull(response);
	 }
	 
	 @Test
	 public void findAllError() {
		 when(repository.findAll()).thenReturn(null);
		 ResponseEntity<List<GenreDto>> response = controller.findAll();
		 assertNotNull(response);

		 when(repository.findAll()).thenReturn(Collections.emptyList());
		 response = controller.findAll();
		 assertNotNull(response);
		 
		 when(repository.findAll()).thenThrow(NullPointerException.class);
		 response = controller.findAll();
		 assertNotNull(response);
	 }
	 
	 @Test
	 public void get() {
		 ResponseEntity<GenreDto> response = controller.findById(ID);
		 assertNotNull(response);
	 }

	 @Test
	 public void getError() {
		 when(repository.findById(ID)).thenReturn(null);
		 ResponseEntity<GenreDto> response = controller.findById(ID);
		 assertNotNull(response);

		 when(repository.findById(ID)).thenReturn(Optional.empty());
		 response = controller.findById(ID);
		 assertNotNull(response);

		 when(repository.findById(ID)).thenThrow(NullPointerException.class);
		 response = controller.findById(ID);
		 assertNotNull(response);
	 }
	 
	 @Test
	 public void create() {
		 ResponseEntity<GenreDto> response = controller.create(dummyDto());
		 assertNotNull(response);
	 }
	 
	 @Test
	 public void createError() {
		 when(repository.save(any(GenreEntity.class))).thenReturn(null);
		 ResponseEntity<GenreDto> response = controller.create(dummyDto());
		 assertNotNull(response);

		 when(repository.save(any(GenreEntity.class))).thenThrow(NullPointerException.class);
		 response = controller.create(dummyDto());
		 assertNotNull(response);
	 }
	 
	 @Test
	 public void update() {
		 ResponseEntity<GenreDto> response = controller.update(dummyDto());
		 assertNotNull(response);
	 }
	 
	 @Test
	 public void updateError() {
		 when(repository.findById(ID)).thenReturn(null);
		 ResponseEntity<GenreDto> response = controller.update(dummyDto());
		 assertNotNull(response);

		 when(repository.findById(ID)).thenReturn(Optional.empty());
		 response = controller.update(dummyDto());
		 assertNotNull(response);

		 when(repository.findById(ID)).thenThrow(NullPointerException.class);
		 response = controller.update(dummyDto());
		 assertNotNull(response);
	 }
	 
	 @Test
	 public void delete() {
		 ResponseEntity<GenreDto> response = controller.delete(ID);
		 assertNotNull(response);
	 }

	 @Test
	 public void deleteError() {
		 when(repository.findById(ID)).thenReturn(null);
		 ResponseEntity<GenreDto> response = controller.delete(ID);
		 assertNotNull(response);

		 when(repository.findById(ID)).thenReturn(Optional.empty());
		 response = controller.delete(ID);
		 assertNotNull(response);

		 when(repository.findById(ID)).thenThrow(NullPointerException.class);
		 response = controller.delete(ID);
		 assertNotNull(response);
	 }
}
