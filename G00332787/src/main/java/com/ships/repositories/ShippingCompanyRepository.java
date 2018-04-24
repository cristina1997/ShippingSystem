package com.ships.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ships.model.ShippingCompany;

public interface ShippingCompanyRepository extends CrudRepository<ShippingCompany, Integer> {
	
}
