package com.service;

import java.util.List;

public class CheckQuantityShortageImpl implements CheckQuantityShortage {

	@Override
	public List<Integer> CheckRequirement(List<Integer> requirement) {
		for(Integer i:requirement)
		{
			System.out.println(i);
		}
		
		return requirement;
	}

}
