package com.lxs.cp.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.lxs.cp.test.constants.ValueConstants;
import com.lxs.cp.test.dto.GenreDto;
import com.lxs.cp.test.dto.SubGenreDto;
import com.lxs.cp.test.entity.SubGenreEntity;
import com.lxs.cp.test.repository.SubGenreRepository;

@Service
public class SubGenreService {
	
	@Autowired
	SubGenreRepository repository;
	
	public List<SubGenreDto> findAll() {
		try {
			List<SubGenreEntity> entities = repository.findAll();
			List<SubGenreDto> dtos = Lists.newArrayList();
			for (SubGenreEntity entity : entities) {
				GenreDto genreDto = GenreDto.builder()
						.id(entity.getGenre().getId())
						.name(entity.getGenre().getName())
						.description(entity.getGenre().getDescription())
						.enable(entity.getGenre().getEnable())
						.build();
				SubGenreDto dto = SubGenreDto.builder()
						.id(entity.getId())
						.name(entity.getName())
						.description(entity.getDescription())
						.enable(entity.getEnable())
						.genre(genreDto)
						.build();
				dtos.add(dto);
			}
			return dtos;
		} catch (Exception e) {
			return Lists.newArrayList();
		}
	}
	
	public SubGenreDto findById(Long id) {
		try {
			SubGenreEntity entity = repository.findById(id).orElse(null);
			if(entity == null) return null;
			GenreDto genreDto = GenreDto.builder()
					.id(entity.getGenre().getId())
					.name(entity.getGenre().getName())
					.description(entity.getGenre().getDescription())
					.enable(entity.getGenre().getEnable())
					.build();
			return SubGenreDto.builder()
					.id(entity.getId())
					.name(entity.getName())
					.description(entity.getDescription())
					.enable(entity.getEnable())
					.genre(genreDto)
					.build();
		} catch (Exception e) {
			return null;
		}
	}
	
	public SubGenreDto create(SubGenreDto dto) {
		try {
			SubGenreEntity entity = SubGenreEntity.builder()
					.genreId(dto.getGenreId())
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
	
	public SubGenreDto update(SubGenreDto dto) {
		try {
			SubGenreEntity entity = repository.findById(dto.getId()).orElse(null);
			if(entity == null) return null;
			entity.setGenreId(dto.getGenreId());
			entity.setName(dto.getName());
			entity.setDescription(dto.getDescription());
			entity.setEnable(dto.getEnable());
			repository.save(entity);
			return dto;
		} catch (Exception e) {
			return null;
		}
	}
	
	public SubGenreDto delete(Long id) {
		try {
			SubGenreEntity entity = repository.findById(id).orElse(null);
			if(entity == null) return null;
			entity.setEnable(ValueConstants.DISABLED);
			repository.save(entity);
			return SubGenreDto.builder()
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
