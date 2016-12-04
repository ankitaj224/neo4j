package edu.uic.ids517.model;

public class TestBean {
private String testId;
private int questionId;
private String  questionType;
private String questionText;
private String Tolerance;
private String correctAnswer;
private int uin;
private int crn;
public String getTestId() {
	return testId;
}
public void setTestId(String testId) {
	this.testId = testId;
}
public int getQuestionId() {
	return questionId;
}
public void setQuestionId(int questionId) {
	this.questionId = questionId;
}
public String getQuestionType() {
	return questionType;
}
public void setQuestionType(String questionType) {
	this.questionType = questionType;
}
public String getQuestionText() {
	return questionText;
}
public void setQuestionText(String questionText) {
	this.questionText = questionText;
}
public String getTolerance() {
	return Tolerance;
}
public void setTolerance(String tolerance) {
	Tolerance = tolerance;
}
public String getCorrectAnswer() {
	return correctAnswer;
}
public void setCorrectAnswer(String correctAnswer) {
	this.correctAnswer = correctAnswer;
}
public int getUin() {
	return uin;
}
public void setUin(int uin) {
	this.uin = uin;
}
public int getCrn() {
	return crn;
}
public void setCrn(int crn) {
	this.crn = crn;
}
public void getAvailableQuestions(){
	
}
public void getFinalScore(){
	
}
}

