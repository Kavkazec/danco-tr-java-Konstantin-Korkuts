package com.danco.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danco.ems.api.repository.LectureRepository;
import com.danco.ems.api.service.ILectureService;
import com.danco.ems.entity.Lecture;

@Service
public class LectureServiceImpl implements ILectureService {
	
	@Autowired
	private LectureRepository lectureRepository;

	public Lecture getById(int id) {
		return lectureRepository.findOne(id);
	}

	public void save(Lecture model) {
		lectureRepository.save(model);
	}

	public void delete(Lecture model) {
		lectureRepository.delete(model);
	}

	public void update(Lecture model) {
		lectureRepository.save(model);
	}

	public List<Lecture> getAll() {
		return lectureRepository.findAll();
	}

}
