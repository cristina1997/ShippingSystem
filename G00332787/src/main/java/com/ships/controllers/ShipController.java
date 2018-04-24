package com.ships.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.Ship;
import com.ships.services.ShipService;


@Controller
public class ShipController {
	@Autowired
	ShipService shipService;
		
	@RequestMapping(value = "/showShips", method=RequestMethod.GET)
	public String listShips(Model model) {
		
		List<Ship> ships = shipService.findAll();							// gets all the values in the ships table
		model.addAttribute("ships", ships);									// it links the data to the returned page containing "ships" attribute
		
		return "showShips";
	}
	
	@RequestMapping(value = "/addShip", method=RequestMethod.GET)
	public String addShipGET(Model model) {

		Ship ship = new Ship();												// it creates a new ship
		model.addAttribute("ship", ship);									// it links the data to the returned page containing "ship" attribute
		
		return "addShip";
	}
	
	@RequestMapping(value = "/addShip", method=RequestMethod.POST)
	public String addShipPOST(@Valid @ModelAttribute("ship") Ship ship, BindingResult result, Model model) {
		
		// return the addShip.jsp page if there are any errors
		if (result.hasErrors())
			return "addShip";		

		shipService.save(ship);												// it saves the data of the ship in the database
		return "redirect:showShips";
	}

}