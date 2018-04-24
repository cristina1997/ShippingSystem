package com.ships.controllers;

import java.math.BigDecimal;
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

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.services.ShipService;
import com.ships.services.OrderInfoService;
import com.ships.services.ShippingCompanyService;

@Controller
public class OrderInfoController {
	@Autowired
	OrderInfoService orderInfoService;
	
	@Autowired
	ShippingCompanyService shippingCompanyService;
	
	@Autowired
	ShipService shipService;
	
	@RequestMapping(value = "/showOrders", method=RequestMethod.GET)
	public String listOrders(Model model) {
		
		List<OrderInfo> orderInfos = orderInfoService.findAll();						// gets all the values in the order info table
		model.addAttribute("orderInfos", orderInfos);									// it links the data to the returned page containing "orderInfos" attribute

		return "showOrderInfo";
	}
	
	@RequestMapping(value = "/createOrder", method=RequestMethod.GET)
	public String createOrderGET(Model model) {


		Map<Integer, String> shippingCompanyList = ShipCompanyList();					// Map the id to the name and the balance (transformed into a string)
		model.addAttribute("shippingCompanyList", shippingCompanyList);					// it links the data to the returned page containing "shippingCompanyList" attribute
		
		Map<Integer, String> shipList = ShipList(); 									// Map the id to the name and the cost (transformed into a string)
		model.addAttribute("shipList", shipList);										// it links the data to the returned page containing "shipList" attribute	
		
		OrderInfo orderInfo = new OrderInfo();											// it creates a new order
		model.addAttribute("orderInfo", orderInfo);										// it links the data to the returned page containing "orderInfo" attribute
		
		return "addOrderInfo";
	}

	private Map<Integer, String> ShipList() {
		// Get List of All Ships
		ArrayList<Ship> ships = (ArrayList<Ship>) shipService.findAll();	
		// Create List of Ships
		Map<Integer,String>shipList = new HashMap<Integer,String>();
		
		// look through all the data in the ships and get the name and the cost corresponding to each id
		for (Ship c : ships) {
			shipList.put(c.getSid(), c.getName() + "; " + c.getCost().toString());
		}	

		return shipList;
	}

	private Map<Integer, String> ShipCompanyList() {
		// Get List of All Shipping Companies
		ArrayList<ShippingCompany> shippingCompanies = (ArrayList<ShippingCompany>) shippingCompanyService.findAll();
		// Create List of Shipping Companies
		Map<Integer,String> shippingCompanyList = new HashMap<Integer,String>();
		
		// look through all the data in the shipping companies and get the name and the balance corresponding to each id 
		for (ShippingCompany c : shippingCompanies) {
			shippingCompanyList.put(c.getScid(), c.getName() + "; " + c.getBalance().toString());
		}

		return shippingCompanyList;
	}
	
	@RequestMapping(value = "/createOrder", method=RequestMethod.POST)
	public String addOrderPOST(@Valid @ModelAttribute("orderInfo") OrderInfo orderInfo, BindingResult result, Model model) {
		boolean isBalanceSmaller;
		BigDecimal shipCost = orderInfo.getShip().getCost();							// get the cost of the ship
		BigDecimal shipCompanyBalance = orderInfo.getShippingCompany().getBalance();	// get the balance of the shipping company
//		System.out.println("Ship Cost: " +shipCost);
//		System.out.println("Ship Balance: " +shipCompanyBalance);
		int comp = shipCost.compareTo(shipCompanyBalance); 								// it compares the cost of the ship and the balance of the shipping company and gets the integer value 1, 0 or -1							

//		System.out.println("Compare Balance with Cost: " +comp);
		
		// if comp is 1 then the cost is bigger than the balance
		// if 0 then they are equal
		// otherwise the cost is smaller than balance
		if(comp == 1)
			isBalanceSmaller = true;
		else
			isBalanceSmaller = false;	
		
		// return the showOrderInfo.jsp page unless there are any other issues
		if (result.hasErrors())
			return "emptyInput";
		else if(isBalanceSmaller)
			return "balanceCostComparison";
		else {
			orderInfoService.save(orderInfo);											// it saves the data of the order in the database
			List<OrderInfo> orderInfos = orderInfoService.findAll();					// gets all the values in the order info table
			model.addAttribute("orderInfos", orderInfos);								// it links the data to the returned page containing "orderInfos"attribute

			return "showOrderInfo";
		}

	}

}