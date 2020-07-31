package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Attempt;
import com.cognizant.ormlearn.model.AttemptQuestion;
import com.cognizant.ormlearn.model.Question;
import com.cognizant.ormlearn.model.User;
import com.cognizant.ormlearn.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public User getUserById(int id) {
		User user = userRepository.getUserById(id);
		return user;
	}

	@Transactional
	public List<User> getAllUser() {
		List<User> userList = userRepository.getAllUser();
		return userList;
	}

	@Transactional
	public User getUserAttemptDetail(int userId, int attemptId) {
		User user = userRepository.getUserAttemptDetail(userId, attemptId);
		return user;
	}

	@Transactional
	public User getUserAttemptDetailFull(int userId, int attemptId) {
		User user = userRepository.getUserAttemptDetailFull(userId, attemptId);
		Set<Attempt> attemptList = user.getAttemptList();
		System.out.println(" User  =   " );
		System.out.println(user.getId() +"   " +user.getName() +"   "+user.getEmail());
		for (Attempt attempt : attemptList) {
			System.out.println("Attempt :  " +attempt);
			Set<AttemptQuestion> attemptQuestionList = attempt.getAttemptQuestionList();
			for (AttemptQuestion attemptQuestion : attemptQuestionList) {
				Question  question =attemptQuestion.getQuestion();
				System.out.println(question.getId()+"   "+question.getQuestionText());

			}
		}
	return user;
	}
}
