package com.ships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.ShippingCompany;
import com.ships.repositories.ShippingCompanyRepository;

@Service
public class ShippingCompanyService {
	@Autowired
	ShippingCompanyRepository shippingCompanyRepository;
	
	public List<ShippingCompany> findAll() {
		return (List<ShippingCompany>) shippingCompanyRepository.findAll();
	}

	public ShippingCompany save(ShippingCompany shippingCompany) {
		 return shippingCompanyRepository.save(shippingCompany);		
	}
}
