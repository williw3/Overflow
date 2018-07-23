package com.leewatterson.overflow.services;

import org.springframework.stereotype.Service;

import com.leewatterson.overflow.models.Answer;
import com.leewatterson.overflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	private final AnswerRepository answerRepository;
	public AnswerService(AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}
	
	public Answer createAnswer(Answer a) {
		return answerRepository.save(a);
	}
}
