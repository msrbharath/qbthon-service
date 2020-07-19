package com.cognizant.academy.qbthon.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cognizant.academy.qbthon.model.Questions;

public interface QuestionBuildService {

	public List<Questions> getQuestions();

	public void createQuestionsTable();

	public void addQuestions(Questions questions);
	
	public void deleteQuestions(String questionId);

	public byte[] downloadTemplate();

	public void uploadTemplate(MultipartFile file, String eventName);

}
