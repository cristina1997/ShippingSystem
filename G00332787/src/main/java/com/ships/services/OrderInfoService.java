package com.ships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ships.model.OrderInfo;
import com.ships.repositories.OrderInfoRepository;

public class OrderInfoService {
	@Autowired
	OrderInfoRepository orderInfoRepository;
	
	public List<OrderInfo> findAll() {
		return (List<OrderInfo>) orderInfoRepository.findAll();
	}
}
