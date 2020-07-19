package com.cognizant.academy.qbthon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cognizant.academy.qbthon.dao.QBThonDao;
import com.cognizant.academy.qbthon.model.AssociateDetail;
import com.cognizant.academy.qbthon.model.Option;
import com.cognizant.academy.qbthon.model.Question;
import com.cognizant.academy.qbthon.model.Questions;
import com.cognizant.academy.qbthon.repository.QuestionBuildRepository;
import com.cognizant.academy.qbthon.utils.ExcelTemplateReadHelper;

@Service
public class QuestionBuildServiceImpl implements QuestionBuildService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(QuestionBuildServiceImpl.class);

	@Autowired
	QBThonDao qbthonDao;
	
	@Autowired
	QuestionBuildRepository questionRepository;
	
	@Autowired
	ExcelTemplateReadHelper excelTemplateReadHelper;
	
	@Override
	public List<Questions> getQuestions() {
		return (List<Questions>) questionRepository.findAll();
	}

	@Override
	public void createQuestionsTable() {
		try {
			qbthonDao.createQuestionsTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addQuestions(Questions questions) {	
		/*
		 * questions = new Questions(); questions.setEventName("event2"); List<Question>
		 * questionList = new ArrayList<Question>(); Question question = new Question();
		 * question.setBloomsTaxonomy("Multiple Choice");
		 * question.setCategory("Application"); question.setDifficultyLevel("Easy");
		 * question.setMultipleAnswers("Yes");
		 * question.setQuestionSource("https://www.google.com");
		 * question.setQuestionText("What is pom"); question.setSkillName("Java");
		 * question.setStatus("New"); question.setTopic("Maven");
		 * question.setSubTopic("Maven Basics"); List<Option> options = new
		 * ArrayList<Option>(); Option option = new Option();
		 * option.setCorrectOption("Yes"); option.setMarks("1");
		 * option.setOptionText("Project Object Model"); options.add(option); option =
		 * new Option(); option.setCorrectOption("No"); option.setMarks("0");
		 * option.setOptionText("Project Model"); options.add(option); option = new
		 * Option(); option.setCorrectOption("No"); option.setMarks("0");
		 * option.setOptionText("Project Object"); options.add(option);
		 * question.setOptions(options ); List<AssociateDetail> reviewerDetail = new
		 * ArrayList<AssociateDetail>(); AssociateDetail associateDetail = new
		 * AssociateDetail(); associateDetail.setAssociateId("123456");
		 * associateDetail.setLastUpdated("15-May-2020");
		 * reviewerDetail.add(associateDetail); associateDetail = new AssociateDetail();
		 * associateDetail.setAssociateId("263721");
		 * associateDetail.setLastUpdated("15-May-2020");
		 * reviewerDetail.add(associateDetail);
		 * question.setReviewerDetail(reviewerDetail);
		 * question.setAssociateDetails(reviewerDetail);
		 * questions.setQuestionList(questionList );
		 */
		questionRepository.save(questions);
	}

	@Override
	public void deleteQuestions(String questionId) {
		Optional<Questions> questionToDelete = questionRepository.findById(questionId);
		if(questionToDelete.isPresent()) {
			questionRepository.delete(questionToDelete.get());
		}else {
			System.out.println("Nothing to delete");
		}
	}

	@Override
	public byte[] downloadTemplate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void uploadTemplate(MultipartFile multipartFile, String eventName) {

		Questions questions = new Questions();
		eventName = "Event 1";
		questions.setEventName(eventName);
		try (Workbook workbook = new XSSFWorkbook(multipartFile.getInputStream())) {
			
			List<Question> questionList = excelTemplateReadHelper.getExcelTemplateData(workbook);	
			questions.setQuestionList(questionList);
			addQuestions(questions);
				
		} catch (Exception e) {
			LOGGER.debug("Exception occured while uploading Questions {} =>", e.getMessage());
		}
		
	}

}
