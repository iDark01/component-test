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

import com.lxs.cp.test.controller.MusicGenderController;
import com.lxs.cp.test.dto.MusicGenderDto;
import com.lxs.cp.test.entity.MusicGenderEntity;
import com.lxs.cp.test.repository.MusicGenderRepository;
import com.lxs.cp.test.service.MusicGenderService;

@RunWith(MockitoJUnitRunner.class)
public class MusicGenderControllerTests {
	private static final Long ID = 1L;
	public static final byte ENABLED = 1;
	
	 @Spy
	 MusicGenderRepository repository;
	 
	 @Spy
	 @InjectMocks
	 MusicGenderService service;
	 
	 @InjectMocks
	 MusicGenderController controller = new MusicGenderController();
	 
	 public MusicGenderDto dummyDto() {
		 return MusicGenderDto.builder()
				 .id(1L)
				 .name("")
				 .description("")
				 .enable(ENABLED)
				 .build();
	 }
	 
	 public MusicGenderEntity dummyEntity() {
		 return MusicGenderEntity.builder()
				 .id(1L)
				 .name("")
				 .description("")
				 .enable(ENABLED)
				 .build();
	 }
	 
	 public List<MusicGenderEntity> dummyList() {
		 return Collections.singletonList(dummyEntity());
	 }
	 
	 @Before
	 public void init() {
		 MockitoAnnotations.initMocks(this);
		 when(repository.findAll()).thenReturn(dummyList());
		 when(repository.findById(ID)).thenReturn(Optional.of(dummyEntity()));
		 when(repository.save(any(MusicGenderEntity.class))).thenReturn(dummyEntity());
	 }
	 
	 @Test
	 public void findAll() {
		 ResponseEntity<List<MusicGenderDto>> response = controller.findAll();
		 assertNotNull(response);
	 }
	 
	 @Test
	 public void findAllError() {
		 when(repository.findAll()).thenReturn(null);
		 ResponseEntity<List<MusicGenderDto>> response = controller.findAll();
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
		 ResponseEntity<MusicGenderDto> response = controller.findById(ID);
		 assertNotNull(response);
	 }

	 @Test
	 public void getError() {
		 when(repository.findById(ID)).thenReturn(null);
		 ResponseEntity<MusicGenderDto> response = controller.findById(ID);
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
		 ResponseEntity<MusicGenderDto> response = controller.create(dummyDto());
		 assertNotNull(response);
	 }
	 
	 @Test
	 public void createError() {
		 when(repository.save(any(MusicGenderEntity.class))).thenReturn(null);
		 ResponseEntity<MusicGenderDto> response = controller.create(dummyDto());
		 assertNotNull(response);

		 when(repository.save(any(MusicGenderEntity.class))).thenThrow(NullPointerException.class);
		 response = controller.create(dummyDto());
		 assertNotNull(response);
	 }
	 
	 @Test
	 public void update() {
		 ResponseEntity<MusicGenderDto> response = controller.update(dummyDto());
		 assertNotNull(response);
	 }
	 
	 @Test
	 public void updateError() {
		 when(repository.findById(ID)).thenReturn(null);
		 ResponseEntity<MusicGenderDto> response = controller.update(dummyDto());
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
		 ResponseEntity<MusicGenderDto> response = controller.delete(ID);
		 assertNotNull(response);
	 }

	 @Test
	 public void deleteError() {
		 when(repository.findById(ID)).thenReturn(null);
		 ResponseEntity<MusicGenderDto> response = controller.delete(ID);
		 assertNotNull(response);

		 when(repository.findById(ID)).thenReturn(Optional.empty());
		 response = controller.delete(ID);
		 assertNotNull(response);

		 when(repository.findById(ID)).thenThrow(NullPointerException.class);
		 response = controller.delete(ID);
		 assertNotNull(response);
	 }
}
