package com.lxs.cp.test.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lxs.cp.test.entity.MusicGenderEntity;

@Repository
public interface MusicGenderRepository extends CrudRepository<MusicGenderEntity, Long> {
	List<MusicGenderEntity> findAll();
}
