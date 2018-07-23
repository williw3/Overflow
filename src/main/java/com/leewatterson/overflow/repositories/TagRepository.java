package com.leewatterson.overflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.leewatterson.overflow.models.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {
	List<Tag> findAll();
	Optional<Tag> findBySubject(String subject);
}
