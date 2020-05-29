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
public class Skill {
	@DynamoDBAttribute(attributeName="skill_name")
	private String skillName;
	
	@DynamoDBTypeConvertedJson
	@DynamoDBAttribute(attributeName="topics")
	private List<Topic> topics;

}