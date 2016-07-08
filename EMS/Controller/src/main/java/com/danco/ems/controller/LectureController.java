package com.danco.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.danco.ems.entity.Lecture;
import com.danco.ems.entity.Pulpit;
import com.danco.ems.entity.Subject;
import com.danco.ems.service.ILectureService;

@RestController
public class LectureController {

	@Autowired
	private ILectureService lectureService;
	
	@RequestMapping(value = "/lecture", method = RequestMethod.GET, produces="application/json; charset=UTF-8")
	public @ResponseBody List<Lecture> getAllLectures() {
		return lectureService.getAll();
	}
	
	@RequestMapping(value = "/lecture/add", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody Lecture addLecture(@RequestBody Lecture lecture) {
		System.out.println("in lecture");
		System.out.println(lecture.getType());
		Lecture model = lectureService.save(lecture);
		return model;

	}
	
	@RequestMapping(value = "/lecture/delete", method = RequestMethod.DELETE, produces="application/json")
	public @ResponseBody ModelAndView  deleteLecture(@RequestParam("id") int id) {
		System.out.println(id);
		ModelAndView map = new ModelAndView();
		Lecture lecture = lectureService.getById(id);
		lectureService.delete(lecture);
		return map;

	}
	
	@RequestMapping(value = "/lecture/edit", method = RequestMethod.PUT, produces="application/json")
	public @ResponseBody ModelAndView  updateLecture(@RequestBody Lecture lecture) {
		System.out.println(lecture.getId());
		ModelAndView map = new ModelAndView();
		lectureService.update(lecture);
		return map;

	}
}
