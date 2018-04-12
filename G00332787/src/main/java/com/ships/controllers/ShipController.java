package com.ships.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.services.ShipService;
import com.ships.services.ShippingCompanyService;


@Controller
public class ShipController {
	// show ships - get
	// add ship - get first to get the page and then post to return the other info when press ok
	// RequestMapping = "/showShips" service.getShips - what service does it calls a method that doessomething in repository and gets it back
	// Repo - CRUD Repository it has a number of built in methods (such as show all, add and delete) that are used
	
	// Show shipping companies - get
	// Add shipping companies get + post like above
	@Autowired
	ShipService shipService;
	
	@Autowired
	ShippingCompanyService shippingCompanyService;
	
	@RequestMapping(value = "/showShips", method=RequestMethod.GET)
	public String listShips(Model model) {
		List<Ship> ships = shipService.findAll();
		model.addAttribute("ships", ships);
			return "showShip";
	}
	
	@RequestMapping(value = "/addShip", method=RequestMethod.GET)
	public String addShipGET(Model model) {

		Ship ship = new Ship();
		model.addAttribute("ship", ship);
		
		return "addShip";
	}
	
	@RequestMapping(value = "/addShip", method=RequestMethod.POST)
	public String addShipPOST(@ModelAttribute("ship") Ship ship, Model model) {
		shipService.save(ship);
		return "redirect:showShips";
	}

}