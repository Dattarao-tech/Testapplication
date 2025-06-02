package com.Demoexample2.Demowork.StudentServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Demoexample2.Demowork.dto.CourseRepository;
import com.Demoexample2.Demowork.entity.Course;
import com.Demoexample2.Demowork.exception.ResourceNotFoundException;
import com.Demoexample2.Demowork.service.CourseService;

@Service
public class CourseServiceImpl  implements CourseService {
	
	@Autowired
	private  CourseRepository  courseRepository;
	
	public Course saveCourse(Course Course) {
		Course newcourse=courseRepository.save(Course);
		return newcourse;
	}
	@Override
	public Course updateCourse(Course course) {	
		String id=course.getCourse_name();
		Course exstingcourse=courseRepository.findById(id).orElse(null);
		if(exstingcourse!=null) {
		exstingcourse.setCompletion_duration_in_days(course.getCompletion_duration_in_days());
		exstingcourse.setFee_amount(course.getFee_amount());
		exstingcourse.setCourse_name(course.getCourse_name());
		exstingcourse.setMax_exam_attempts(course.getMax_exam_attempts());
		exstingcourse.setEnabled_from_date(course.getEnabled_from_date());
		exstingcourse.setEnabled_to_date(course.getEnabled_to_date());
		return courseRepository.save(exstingcourse);
		}
		else {
			throw new ResourceNotFoundException("Course","id",id);
		}
	}
	@Override
	public Course findByCourseName(Course course) {
		// TODO Auto-generated method stub
		String id=course.getCourse_name();
		Course newCourse=courseRepository.findById(id).orElse(null);
		if(newCourse!=null) {
			newCourse.getCourse_name();
			newCourse.getEnabled_from_date();
			newCourse.getEnabled_to_date();
			newCourse.getFee_amount();
			newCourse.getCompletion_duration_in_days();
			newCourse.getMax_exam_attempts();
			return  courseRepository.save(newCourse);
		}
		throw new ResourceNotFoundException("Course","id",id);
		
	}	
}

	
