package com.danco.training.main;

import com.danco.training.controller.api.IHotelController;
import com.danco.training.controller.api.IRoomService;
import com.danco.training.di.DependencyInjection;


public class Test {
	public static void main(String[] args) {
		IRoomService rs = (IRoomService) DependencyInjection.getInstance().getClassInstance(IRoomService.class);
		System.out.println(rs.getClass().getName());
		IHotelController gs = (IHotelController) DependencyInjection.getInstance().getClassInstance(IHotelController.class);
		System.out.println(gs.getClass().getName());
	}
}
