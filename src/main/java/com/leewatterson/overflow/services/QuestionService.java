package com.leewatterson.overflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.leewatterson.overflow.models.Question;
import com.leewatterson.overflow.models.Tag;
import com.leewatterson.overflow.repositories.QuestionRepository;


@Service
public class QuestionService {
	private final QuestionRepository questionRepository;
	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	
	public List<Question> allQuestions(){
		return questionRepository.findAll();
	}
	
	public Question createQuestion(Question q) {
		return questionRepository.save(q);
	}
	
	public Question findOne(String question) {
		Optional<Question> optionalQuestion = questionRepository.findByQuestion(question);
		if(optionalQuestion.isPresent()) {
			return optionalQuestion.get();
		}
		else {
			return null;
		}
	}
	
	public Question findOneQuestion(Long id) {
		Optional<Question> optionalQuestion = questionRepository.findById(id);
		if(optionalQuestion.isPresent()) {
			return optionalQuestion.get();
		}
		else {
			return null;
		}
	}
	
	public Question updateQuestion(Question question) {
		return questionRepository.save(question);
	}
	
	public List<Tag> findTags(Long id){
		Optional<Question> optionalQuestion = questionRepository.findById(id);
		if(optionalQuestion.isPresent()) {
			Question q = optionalQuestion.get();
			return q.getTags();
		}
		else {
			return null;
		}
	}
}





