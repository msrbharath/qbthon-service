package com.cognizant.academy.qbthon.utils;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import com.cognizant.academy.qbthon.model.Question;



@Component
public class ExcelTemplateReadHelper {

	/**
	 * Method to get question data from excel sheet(data sheet).
	 * 
	 * @param workbook
	 * @return excelMap
	 * @throws Exception
	 */
	public List<Question> getExcelTemplateData(Workbook workbook) throws Exception {
		
		List<Question> questions = new ArrayList<>();		
		try {
			Sheet sheet = workbook.getSheetAt(1);

			Row dayHeaderRow = sheet.getRow(0);
			for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
				Question question = new Question();
				Row dataRow = sheet.getRow(rowIndex);

				String cellTitle = "";
				for (int columnIndex = 0; columnIndex < dataRow.getLastCellNum(); columnIndex++) {
					String param = "";
					cellTitle = readCellData(dayHeaderRow.getCell(columnIndex));
					if (null != readCellData(dayHeaderRow.getCell(columnIndex)) 
							&& "" != readCellData(dayHeaderRow.getCell(columnIndex))) {
						
						param = cellTitle;
					} 
					if("Blooms Taxonomy".equalsIgnoreCase(StringUtils.trimToEmpty(param))) {
						question.setBloomsTaxonomy(readParamCellData(dataRow.getCell(columnIndex)));
					}
					if("Difficulty Level".equalsIgnoreCase(StringUtils.trimToEmpty(param))) {
						question.setDifficultyLevel(readParamCellData(dataRow.getCell(columnIndex)));
					}
					if("Category".equalsIgnoreCase(StringUtils.trimToEmpty(param))) {
						question.setCategory(readParamCellData(dataRow.getCell(columnIndex)));
					}
					if("Multiple Answer".equalsIgnoreCase(StringUtils.trimToEmpty(param))) {
						question.setMultipleAnswers(readParamCellData(dataRow.getCell(columnIndex)));
					}
					if("Topic".equalsIgnoreCase(StringUtils.trimToEmpty(param))) {
						question.setTopic(readParamCellData(dataRow.getCell(columnIndex)));
					}
					if("Question Text".equalsIgnoreCase(StringUtils.trimToEmpty(param))) {
						question.setQuestionText(readParamCellData(dataRow.getCell(columnIndex)));
					}
					if("Option 1".equalsIgnoreCase(StringUtils.trimToEmpty(param))) {
						question.setOption1(readParamCellData(dataRow.getCell(columnIndex)));
					}
					if("Correct Answer 1".equalsIgnoreCase(StringUtils.trimToEmpty(param))) {
						question.setOption1Correct(readParamCellData(dataRow.getCell(columnIndex)));
					}
					if("Option 2".equalsIgnoreCase(StringUtils.trimToEmpty(param))) {
						question.setOption2(readParamCellData(dataRow.getCell(columnIndex)));
					}
					if("Correct Answer 2".equalsIgnoreCase(StringUtils.trimToEmpty(param))) {
						question.setOption2Correct(readParamCellData(dataRow.getCell(columnIndex)));
					}
					if("Option 3".equalsIgnoreCase(StringUtils.trimToEmpty(param))) {
						question.setOption3(readParamCellData(dataRow.getCell(columnIndex)));
					}
					if("Correct Answer 3".equalsIgnoreCase(StringUtils.trimToEmpty(param))) {
						question.setOption3Correct(readParamCellData(dataRow.getCell(columnIndex)));
					}
					if("Option 4".equalsIgnoreCase(StringUtils.trimToEmpty(param))) {
						question.setOption4(readParamCellData(dataRow.getCell(columnIndex)));
					}
					if("Correct Answer 4".equalsIgnoreCase(StringUtils.trimToEmpty(param))) {
						question.setOption4Correct(readParamCellData(dataRow.getCell(columnIndex)));
					}
					if("Option 5".equalsIgnoreCase(StringUtils.trimToEmpty(param))) {
						question.setOption5(readParamCellData(dataRow.getCell(columnIndex)));
					}
					if("orrect Answer 5".equalsIgnoreCase(StringUtils.trimToEmpty(param))) {
						question.setOption5Correct(readParamCellData(dataRow.getCell(columnIndex)));
					}
					if("Question Source".equalsIgnoreCase(StringUtils.trimToEmpty(param))) {
						question.setQuestionSource(readParamCellData(dataRow.getCell(columnIndex)));
					}
													
					questions.add(question);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return questions;
	}

	/**
	 * Method to read cell value.
	 * 
	 * @param cell
	 * @return cellValue
	 */
	private String readCellData(Cell cell) {
		String cellValue = "";
		if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
			cellValue = cell.getStringCellValue();
		} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			Long value = (long) cell.getNumericCellValue();
			cellValue = String.valueOf(value);
		}
		return cellValue;
	}
	
	/**
	 * Method to read parameter cell value.
	 * 
	 * @param cell
	 * @return cellValue
	 */
	private String readParamCellData(Cell cell) {
		String cellValue = "";
		if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
			cellValue = cell.getStringCellValue();
		} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			Long value = (long) cell.getNumericCellValue();
			cellValue = String.valueOf(value);
		}
		return cellValue;
	}

}
