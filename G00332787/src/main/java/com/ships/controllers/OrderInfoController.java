package com.ships.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.OrderInfo;
import com.ships.services.OrderInfoService;

public class OrderInfoController {
	@Autowired
	OrderInfoService orderInfoService;
	
	@RequestMapping(value = "/showOrders", method=RequestMethod.GET)
	public String listOrders(Model model) {
		List<OrderInfo> orderInfo = orderInfoService.findAll();
		model.addAttribute("orderInfoService", orderInfo);
			return "showOrderInfo";
	}
}
