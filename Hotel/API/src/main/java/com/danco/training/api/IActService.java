package com.danco.training.api;

import java.util.List;

import com.danco.training.entity.Act;

public interface IActService {
	public Act getByIdAct(int id);
	
	public void addAct(Act act);
	
	public void deleteAct(Act act);
	
	public void updateAct(Act act);
	
	public List<Act> getActs();
	
}
