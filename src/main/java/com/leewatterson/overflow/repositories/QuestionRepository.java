package com.leewatterson.overflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.leewatterson.overflow.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {
	List<Question> findAll();
	Optional <Question> findByQuestion(String question);
}
