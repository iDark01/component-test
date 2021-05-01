package com.lxs.cp.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.lxs.cp.test.dto.MusicGenderDto;
import com.lxs.cp.test.entity.MusicGenderEntity;
import com.lxs.cp.test.repository.MusicGenderRepository;

@Service
public class MusicGenderService {

	public static final byte ENABLED = 1;
	public static final byte DISABLED = 0;
	
	@Autowired
	MusicGenderRepository repository;
	
	public List<MusicGenderDto> findAll() {
		try {
			List<MusicGenderEntity> entities = repository.findAll();
			List<MusicGenderDto> dtos = Lists.newArrayList();
			for (MusicGenderEntity entity : entities) {
				MusicGenderDto dto = MusicGenderDto.builder()
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
	
	public MusicGenderDto findById(Long id) {
		try {
			MusicGenderEntity entity = repository.findById(id).orElse(null);
			if(entity == null) return null;
			return MusicGenderDto.builder()
					.id(entity.getId())
					.name(entity.getName())
					.description(entity.getDescription())
					.enable(entity.getEnable())
					.build();
		} catch (Exception e) {
			return null;
		}
	}
	
	public MusicGenderDto create(MusicGenderDto dto) {
		try {
			MusicGenderEntity entity = MusicGenderEntity.builder()
					.id(dto.getId())
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
	
	public MusicGenderDto update(MusicGenderDto dto) {
		try {
			MusicGenderEntity entity = repository.findById(dto.getId()).orElse(null);
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
	
	public MusicGenderDto delete(Long id) {
		try {
			MusicGenderEntity entity = repository.findById(id).orElse(null);
			if(entity == null) return null;
			entity.setEnable(DISABLED);
			repository.save(entity);
			return MusicGenderDto.builder()
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
