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
import com.lxs.cp.test.controller.SubGenreController;
import com.lxs.cp.test.dto.SubGenreDto;
import com.lxs.cp.test.entity.SubGenreEntity;
import com.lxs.cp.test.repository.SubGenreRepository;
import com.lxs.cp.test.service.SubGenreService;

@RunWith(MockitoJUnitRunner.class)
public class SubGenreControllerTests {
	
	private static final Long ID = 1L;
	
	 @Spy
	 SubGenreRepository repository;
	 
	 @Spy
	 @InjectMocks
	 SubGenreService service;
	 
	 @InjectMocks
	 SubGenreController controller = new SubGenreController();
	 
	 public SubGenreDto dummyDto() {
		 return SubGenreDto.builder()
				 .id(1L)
				 .name("")
				 .description("")
				 .enable(ValueConstants.ENABLED)
				 .build();
	 }
	 
	 public SubGenreEntity dummyEntity() {
		 return SubGenreEntity.builder()
				 .id(1L)
				 .name("")
				 .description("")
				 .enable(ValueConstants.ENABLED)
				 .build();
	 }
	 
	 public List<SubGenreEntity> dummyList() {
		 return Collections.singletonList(dummyEntity());
	 }
	 
	 @Before
	 public void init() {
		 MockitoAnnotations.initMocks(this);
		 when(repository.findAll()).thenReturn(dummyList());
		 when(repository.findById(ID)).thenReturn(Optional.of(dummyEntity()));
		 when(repository.save(any(SubGenreEntity.class))).thenReturn(dummyEntity());
	 }
	 
	 @Test
	 public void findAll() {
		 ResponseEntity<List<SubGenreDto>> response = controller.findAll();
		 assertNotNull(response);
	 }
	 
	 @Test
	 public void findAllError() {
		 when(repository.findAll()).thenReturn(null);
		 ResponseEntity<List<SubGenreDto>> response = controller.findAll();
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
		 ResponseEntity<SubGenreDto> response = controller.findById(ID);
		 assertNotNull(response);
	 }

	 @Test
	 public void getError() {
		 when(repository.findById(ID)).thenReturn(null);
		 ResponseEntity<SubGenreDto> response = controller.findById(ID);
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
		 ResponseEntity<SubGenreDto> response = controller.create(dummyDto());
		 assertNotNull(response);
	 }
	 
	 @Test
	 public void createError() {
		 when(repository.save(any(SubGenreEntity.class))).thenReturn(null);
		 ResponseEntity<SubGenreDto> response = controller.create(dummyDto());
		 assertNotNull(response);

		 when(repository.save(any(SubGenreEntity.class))).thenThrow(NullPointerException.class);
		 response = controller.create(dummyDto());
		 assertNotNull(response);
	 }
	 
	 @Test
	 public void update() {
		 ResponseEntity<SubGenreDto> response = controller.update(dummyDto());
		 assertNotNull(response);
	 }
	 
	 @Test
	 public void updateError() {
		 when(repository.findById(ID)).thenReturn(null);
		 ResponseEntity<SubGenreDto> response = controller.update(dummyDto());
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
		 ResponseEntity<SubGenreDto> response = controller.delete(ID);
		 assertNotNull(response);
	 }

	 @Test
	 public void deleteError() {
		 when(repository.findById(ID)).thenReturn(null);
		 ResponseEntity<SubGenreDto> response = controller.delete(ID);
		 assertNotNull(response);

		 when(repository.findById(ID)).thenReturn(Optional.empty());
		 response = controller.delete(ID);
		 assertNotNull(response);

		 when(repository.findById(ID)).thenThrow(NullPointerException.class);
		 response = controller.delete(ID);
		 assertNotNull(response);
	 }
}
