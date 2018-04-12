package com.ships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.ShippingCompany;
import com.ships.repositories.ShippingCompanyRepository;

@Service
public class ShippingCompanyService {
	@Autowired
	ShippingCompanyRepository shipCompanyRepository;
	
	public List<ShippingCompany> findAll() {
		return (List<ShippingCompany>) shipCompanyRepository.findAll();
	}
}
