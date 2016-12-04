package edu.uic.ids517.model;

import java.util.List;

public class CourseBean {
private String courseDescription;
private List<CourseBean> cB;

public List<CourseBean> getcB() {
	return cB;
}

public void setcB(List<CourseBean> cB) {
	this.cB = cB;
}

public String getCourseDescription() {
	return courseDescription;
}

public void setCourseDescription(String courseDescription) {
	this.courseDescription = courseDescription;
}


@Override
	public String toString() {
		// TODO Auto-generated method stub
	
		return super.toString();
	}
}
