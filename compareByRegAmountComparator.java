package com.cms.Comparators;

import java.util.Comparator;

import com.cms.cores.Customer;

public class compareByRegAmountComparator implements Comparator<Customer>{

	@Override
	public int compare(Customer o1, Customer o2) {
		if(o1.getRegAmount() < o2.getRegAmount()) return -1 ;
		if(o1.getRegAmount() == o2.getRegAmount()) return 0;
		return 1 ;
	}

}