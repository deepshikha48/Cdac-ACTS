package com.app.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dao.PassengerRepository;
import com.app.pojos.Passenger;

@Service
@Transactional
public class PassengerServiceImpl implements IPassengerService {
	@Autowired
	private PassengerRepository dao;

	@Override
	public Passenger savePassenger(Passenger passenger) {
		return dao.save(passenger);
	}

}
