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
	// Show shipping companies - get
	// Add shipping companies get + post like above
	@Autowired
	ShipService shipService;
		
	@RequestMapping(value = "/showShips", method=RequestMethod.GET)
	public String listShips(Model model) {
		
		List<Ship> ships = shipService.findAll();
		model.addAttribute("ships", ships);
		
		return "showShips";
	}
	
	@RequestMapping(value = "/addShip", method=RequestMethod.GET)
	public String addShipGET(Model model) {

		Ship ship = new Ship();
		model.addAttribute("ship", ship);
		
		return "addShip";
	}
	
	@RequestMapping(value = "/addShip", method=RequestMethod.POST)
	public String addShipPOST(@Valid @ModelAttribute("ship") Ship ship, BindingResult result, Model model) {
		
		if (result.hasErrors())
			return "addShip";
		
		shipService.save(ship);
		return "redirect:showShips";
	}

}