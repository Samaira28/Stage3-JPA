package com.cognizant.ormlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Question;
import com.cognizant.ormlearn.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepository;

	public Question getQuestiontionById(int id) {
		Question question = questionRepository.getQuestiontionById(id);
		return question;
	}
}
