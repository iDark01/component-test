package com.lxs.cp.test.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lxs.cp.test.entity.SubGenreEntity;

@Repository
public interface SubGenreRepository extends CrudRepository<SubGenreEntity, Long> {
	List<SubGenreEntity> findAll();
}
