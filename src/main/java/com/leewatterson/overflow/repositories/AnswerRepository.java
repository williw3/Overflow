package com.leewatterson.overflow.repositories;

import org.springframework.data.repository.CrudRepository;

import com.leewatterson.overflow.models.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
	
}
