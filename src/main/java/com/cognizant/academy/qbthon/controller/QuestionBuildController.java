package com.cognizant.academy.qbthon.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cognizant.academy.qbthon.model.Questions;
import com.cognizant.academy.qbthon.service.QuestionBuildService;

@RestController
@RequestMapping("/api/questions")
public class QuestionBuildController {


	@Autowired
	QuestionBuildService questionBuildService;
	
	@RequestMapping(value = "/", produces = {"application/json"}, method = RequestMethod.GET)
	public ResponseEntity<List<Questions>> getQuestions() {
		
		return 		ResponseEntity.status(HttpStatus.OK).body(questionBuildService.getQuestions());
	}
	
	@RequestMapping(value = "/create", produces = {"application/json"}, method = RequestMethod.GET)
	public void createQuestionsTable() {
		
		questionBuildService.createQuestionsTable();
		ResponseEntity.status(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", produces = {"application/json"}, method = RequestMethod.POST)
	public void addQuestions(@RequestBody Questions questions) {
		
		questionBuildService.addQuestions(questions);
		ResponseEntity.status(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{questionId}", produces = {"application/json"}, method = RequestMethod.DELETE)
	public void deleteQuestions(@PathVariable String questionId) {
		questionBuildService.deleteQuestions(questionId);
		ResponseEntity.status(HttpStatus.OK);
	}	


	@PostMapping("/downloadtemplate")
	public byte[] downloadTemplate() throws IOException {
		return questionBuildService.downloadTemplate();
	}



	@PostMapping("/uploadbulkquestion")
	public void bulkUploadQuestion(@RequestParam("file") MultipartFile file, String eventName) throws IOException {
		questionBuildService.uploadTemplate(file, eventName);
		ResponseEntity.status(HttpStatus.OK);
	}

}
