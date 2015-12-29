package com.danco.training.Comparator;

import java.util.Comparator;

import com.danco.training.Model.GuestModel;

public class GuestNameComparator implements Comparator<GuestModel> {
	public int compare(GuestModel a, GuestModel b){
		return a.getName().compareTo(b.getName());
	}
}
