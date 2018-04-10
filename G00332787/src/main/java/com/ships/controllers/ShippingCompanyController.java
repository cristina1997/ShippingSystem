package com.ships.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.ShippingCompany;
import com.ships.services.ShippingCompanyService;

public class ShippingCompanyController {
	@Autowired
	ShippingCompanyService shippingCompanyService;
	
	@RequestMapping(value = "/showShippingCompany", method=RequestMethod.GET)
	public String listShippingCompany(Model model) {
		List<ShippingCompany> shippingCompany = shippingCompanyService.findAll();
		model.addAttribute("shippingCompany", shippingCompany);
			return "showShippingCompany";
	}
}
