package com.ships.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.repositories.OrderInfoRepository;
import com.ships.repositories.ShipRepository;
import com.ships.repositories.ShippingCompanyRepository;

@Service
public class OrderInfoService {
	@Autowired
	OrderInfoRepository orderInfoRepository;
	@Autowired
	ShipRepository shipRepository;
	@Autowired
	ShippingCompanyRepository shipCompanyRepository;
	
	Ship ship;
	ShippingCompany shippingCompany;
	
	
	public List<OrderInfo> findAll() {
		return (List<OrderInfo>) orderInfoRepository.findAll();
	}
	
	public OrderInfo save(OrderInfo orderInfo) {
		
		setCurrentDate(orderInfo);																			// sets the new order to the current date
		
		ship = shipRepository.findOne(orderInfo.getShip().getSid());										// it looks for the ship by its id to put it in the order table
		shippingCompany = shipCompanyRepository.findOne(orderInfo.getShippingCompany().getScid());			// it looks for the shipping company by its id to put it in the order table
		
		ship.setShippingCompany(shippingCompany);															// it tells the ship which shipping companyis associated with it
		return orderInfoRepository.save(orderInfo);		
	}
	
	private void setCurrentDate(OrderInfo orderInfo){
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate now = LocalDate.now();;
		orderInfo.setDate(dateFormat.format(now));
	}
}
