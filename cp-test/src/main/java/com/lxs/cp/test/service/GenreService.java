package com.lxs.cp.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.lxs.cp.test.constants.ValueConstants;
import com.lxs.cp.test.dto.GenreDto;
import com.lxs.cp.test.entity.GenreEntity;
import com.lxs.cp.test.repository.GenreRepository;

@Service
public class GenreService {
	
	@Autowired
	GenreRepository repository;
	
	public List<GenreDto> findAll() {
		try {
			List<GenreEntity> entities = repository.findAll();
			List<GenreDto> dtos = Lists.newArrayList();
			for (GenreEntity entity : entities) {
				GenreDto dto = GenreDto.builder()
						.id(entity.getId())
						.name(entity.getName())
						.description(entity.getDescription())
						.enable(entity.getEnable())
						.build();
				dtos.add(dto);
			}
			return dtos;
		} catch (Exception e) {
			return Lists.newArrayList();
		}
	}
	
	public GenreDto findById(Long id) {
		try {
			GenreEntity entity = repository.findById(id).orElse(null);
			if(entity == null) return null;
			return GenreDto.builder()
					.id(entity.getId())
					.name(entity.getName())
					.description(entity.getDescription())
					.enable(entity.getEnable())
					.build();
		} catch (Exception e) {
			return null;
		}
	}
	
	public GenreDto create(GenreDto dto) {
		try {
			GenreEntity entity = GenreEntity.builder()
					.name(dto.getName())
					.description(dto.getDescription())
					.enable(dto.getEnable())
					.build();
			repository.save(entity);
			dto.setId(entity.getId());
			return dto;
		} catch (Exception e) {
			return null;
		}
	}
	
	public GenreDto update(GenreDto dto) {
		try {
			GenreEntity entity = repository.findById(dto.getId()).orElse(null);
			if(entity == null) return null;
			entity.setName(dto.getName());
			entity.setDescription(dto.getDescription());
			entity.setEnable(dto.getEnable());
			repository.save(entity);
			return dto;
		} catch (Exception e) {
			return null;
		}
	}
	
	public GenreDto delete(Long id) {
		try {
			GenreEntity entity = repository.findById(id).orElse(null);
			if(entity == null) return null;
			entity.setEnable(ValueConstants.DISABLED);
			repository.save(entity);
			return GenreDto.builder()
					.id(entity.getId())
					.name(entity.getName())
					.description(entity.getDescription())
					.enable(entity.getEnable())
					.build();
		} catch (Exception e) {
			return null;
		}
	}
}
