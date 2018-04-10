package com.ships.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.Ship;
import com.ships.services.ShipService;


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
	
	@RequestMapping(value = "/showShip", method=RequestMethod.GET)
	public String listShips(Model model) {
		List<Ship> ship = shipService.findAll();
		model.addAttribute("ship", ship);
			return "showShipping";
	}

}