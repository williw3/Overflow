package com.leewatterson.overflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.leewatterson.overflow.models.Tag;
import com.leewatterson.overflow.repositories.TagRepository;

@Service
public class TagService {
	private final TagRepository tagRepository;
	public TagService(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}
	
	public List<Tag> allTags(){
		return tagRepository.findAll();
	}
	
	public Tag findOne(String subject) {
		Optional<Tag> optionalTag = tagRepository.findBySubject(subject);
		if(optionalTag.isPresent()) {
			return optionalTag.get();
		}
		else {
			return null;
		}
	}
	
	public Tag searchForTag(String subject) {
		Optional<Tag> optionalTag = tagRepository.findBySubject(subject);
		if(optionalTag.isPresent()) {
			System.out.println("Tag already exists");
			return optionalTag.get();
		}
		else {
			System.out.println("Tag not found");
			return null;
		}
	}
	
	public Tag createTag(Tag t) {
		tagRepository.save(t);
		return tagRepository.save(t);
	}
	
}

