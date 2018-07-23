package com.leewatterson.overflow.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.leewatterson.overflow.models.Answer;
import com.leewatterson.overflow.models.Question;
import com.leewatterson.overflow.models.Tag;
import com.leewatterson.overflow.services.AnswerService;
import com.leewatterson.overflow.services.QuestionService;
import com.leewatterson.overflow.services.TagService;

@Controller
public class QuestionController {
	private final QuestionService questionService;
	private final TagService tagService;
	private final AnswerService answerService;
	public QuestionController(QuestionService questionService, TagService tagService, AnswerService answerService) {
		this.questionService = questionService;
		this.tagService = tagService;
		this.answerService = answerService;
	}
	
	@RequestMapping("/questions/new")
	public String newQuestion(@ModelAttribute("query") Question question) {
		
		return "/questions/new.jsp";
	}
	
	@RequestMapping("/questions/dash")
	public String dash(Model model) {
		List<Question> questions = questionService.allQuestions();
		model.addAttribute("questions", questions);
		return "questions/dash.jsp";
	}
	
	@RequestMapping(value="/questions",  method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("query") Question question, @RequestParam("tagsInput") String tagsInput, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Errors Found");
			return "/questions/new.jsp";
		}
		else {
			Question myQuestion = questionService.findOne(question.getQuestion());
			if(myQuestion == null) {						//if question does not exist, create new, find and return
				questionService.createQuestion(question);
				myQuestion = questionService.findOne(question.getQuestion());
				System.out.println("New question created: " + myQuestion.getQuestion());
			}
			System.out.println("Before: " + tagsInput); //split comma separated values input to array
			ArrayList<String> splitTags = new ArrayList<String>(Arrays.asList(tagsInput.toLowerCase().split(",")));
			System.out.println("After: " + splitTags);
			List<Tag> tagList = new ArrayList<Tag>();
			System.out.println("TAG LIST FOR THIS Q: " + tagList);
			
			for(int i = 0; i < splitTags.size(); i++) {   //loop input values, if null create new
				String tagSubject = splitTags.get(i);
				Tag myTag = tagService.findOne(tagSubject);
				if(myTag == null) {
					Tag newTag = new Tag(tagSubject);
					tagService.createTag(newTag);
					System.out.println("New tag created: " + newTag.getSubject());
					tagList.add(newTag);
				}
				
				myQuestion.setTags(tagList);
				questionService.updateQuestion(myQuestion);
			}
			return "redirect:/questions/dash";
		}
	}
	
	@RequestMapping("/questions/{id}")
		public String show(@PathVariable("id") Long id, Model model, @ModelAttribute("solution") Answer answer) {
			Question thisQuestion = questionService.findOneQuestion(id);
			model.addAttribute("thisQuestion", thisQuestion);
			return "/questions/show.jsp";
		}
	
	@RequestMapping(value="/answers",  method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("solution") Answer answer, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Errors Found");
			return "/questions/show.jsp";
		}
		else {
			answerService.createAnswer(answer);
			System.out.println("New Answer Created" + answer.getAnswer());
			return "redirect:/questions/dash";
		}
	}
}





