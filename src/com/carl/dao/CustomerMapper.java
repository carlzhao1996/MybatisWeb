package com.carl.dao;

import java.util.List;

import com.carl.pojo.Customer;

public interface CustomerMapper {
	
	public List<Customer> getCustomerList();
	
	public List<Customer> getCustomerByName(String cu_name);

}
