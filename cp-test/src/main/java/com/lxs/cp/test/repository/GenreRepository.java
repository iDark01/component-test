package com.lxs.cp.test.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lxs.cp.test.entity.GenreEntity;

@Repository
public interface GenreRepository extends CrudRepository<GenreEntity, Long> {
	List<GenreEntity> findAll();
}