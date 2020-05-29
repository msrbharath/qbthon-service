package com.cognizant.academy.qbthon.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;

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
public class Option {

	@DynamoDBAttribute(attributeName="option_text")
	private String optionText;
	
	@DynamoDBAttribute(attributeName="correct_option")
	private String correctOption;
	
	@DynamoDBAttribute(attributeName="marks")
	private String marks;
	
}
