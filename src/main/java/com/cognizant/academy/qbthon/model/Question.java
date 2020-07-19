package com.cognizant.academy.qbthon.model;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedJson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {

	//Will have value Either Multiple Choice / True or False
	@DynamoDBAttribute(attributeName="blooms_taxonomy")
	private String bloomsTaxonomy;
	
	//Can have values Easy / Average / Difficult
	@DynamoDBAttribute(attributeName="difficulty_level")
	private String difficultyLevel;
	
	//Will have values Analysis / Application
	@DynamoDBAttribute(attributeName="category")
	private String category;
	
	@DynamoDBAttribute(attributeName="multiple_answers")
	private String multipleAnswers;
	
	@DynamoDBAttribute(attributeName="question_text")
	private String questionText;
	
	@DynamoDBTypeConvertedJson
	@DynamoDBAttribute(attributeName="options")
	private List<Option> options;
	
	@DynamoDBAttribute(attributeName="option1")
	String option1;
	
	@DynamoDBAttribute(attributeName="option1Correct")
	String option1Correct;
	
	@DynamoDBAttribute(attributeName="option2")
	String option2;
	
	@DynamoDBAttribute(attributeName="option2Correct")
	String option2Correct;
	
	@DynamoDBAttribute(attributeName="option3")
	String option3;
	
	@DynamoDBAttribute(attributeName="option3Correct")
	String option3Correct;
	
	@DynamoDBAttribute(attributeName="option4")
	String option4;
	
	@DynamoDBAttribute(attributeName="option4Correct")
	String option4Correct;
	
	@DynamoDBAttribute(attributeName="option5")
	String option5;
	
	@DynamoDBAttribute(attributeName="option5Correct")
	String option5Correct;
	
	
	@DynamoDBAttribute(attributeName="question_source")
	private String questionSource;
	
	@DynamoDBAttribute(attributeName="skill_name")
	private String skillName ;
	
	@DynamoDBAttribute(attributeName="topic")
	private String topic ;
	
	@DynamoDBAttribute(attributeName="sub_topic")
	private String subTopic;
	
	@DynamoDBTypeConvertedJson
	@DynamoDBAttribute(attributeName="associate_details")
	private List<AssociateDetail> associateDetails ;
	
	@DynamoDBTypeConvertedJson
	@DynamoDBAttribute(attributeName="reviewer_detail")
	private List<AssociateDetail> reviewerDetail ;
	
	@DynamoDBAttribute(attributeName = "status")
	private String status;
	
}
