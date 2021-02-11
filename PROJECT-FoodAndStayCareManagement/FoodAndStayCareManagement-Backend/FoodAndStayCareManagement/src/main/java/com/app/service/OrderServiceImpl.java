package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Order;
import com.app.repository.OrderRepository;
@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

	@Autowired 
	private OrderRepository orderRepo;
	@Override
	public Order addNewItemToOrder(Order order) {

		return orderRepo.save(order);
	}

}
