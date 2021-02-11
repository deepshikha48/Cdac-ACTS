package com.app.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.app.pojos.MenuItem;
import com.app.pojos.Order;
import com.app.pojos.User;
import com.app.service.ICanteenMenuService;
import com.app.service.IOrderService;
import com.app.service.IUserService;

@RestController
@RequestMapping("/order")
@CrossOrigin("http://localhost:4200")
public class OrderController {

	@Autowired
	private IOrderService orderService;

	@Autowired
	private ICanteenMenuService canteenService;

	@Autowired
	private IUserService userService;
	
	@Autowired
	private JavaMailSender mail;

	@PostMapping("/{studentId}")
	public ResponseEntity<?> orderListOfMenu(@RequestBody MenuItem[] orderItems,
			@PathVariable int studentId,Order studentOrder) {
		String str="";
		for(MenuItem item :orderItems)
			str+=item.getTotalQuantity()+"  "+item.getItemName()+"\n";

		if (!checkQuantityFromDB(orderItems))
			throw new HttpClientErrorException(HttpStatus.NOT_ACCEPTABLE);//406
		
		studentOrder.setTotalBillingAmount(calcBillAndUpdateQuantityInDB(orderItems));
		User student=userService.getUserById(studentId).get();
		studentOrder.setStudent(student);
		Order order=orderService.addNewItemToOrder(studentOrder);
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(student.getEmail());
		mailMessage.setSubject("Ordered Details by FSCM");
		String message="Dear " + student.getFirstName() + ",\n\nDate: "+ LocalDate.now()+" Time: "+LocalTime.now()+"\nOrderId:" + order.getId() + "\n";
		message+=str;
		message+="Paid: "+studentOrder.getTotalBillingAmount()+ " Rs.\n\nRegards,\nFSCM Family :)";
		mailMessage.setText(message);		
		mail.send(mailMessage);
		
		
		return new ResponseEntity<>(order.getId(), HttpStatus.OK);

	}

	public boolean checkQuantityFromDB(MenuItem items[]) {
		
		
		for (MenuItem m : items) {
			int itemId = m.getId();
			int totalQuantityOrdered = m.getTotalQuantity();
			int totalQuantityInDB = canteenService.getMenuById(itemId).get().getTotalQuantity();

			if (totalQuantityOrdered > totalQuantityInDB) {
				return false;
			}
		}
		return true;
	}

	public int calcBillAndUpdateQuantityInDB(MenuItem items[]) {
		int totalBill = 0;
		for (MenuItem m : items) {
			int itemId = m.getId();
			int totalQuantityOrdered = m.getTotalQuantity();
			int totalQuantityInDB = canteenService.getMenuById(itemId).get().getTotalQuantity();

			totalBill += totalQuantityOrdered * (m.getPrice());
			
			m.setTotalQuantity(totalQuantityInDB - totalQuantityOrdered);
			canteenService.updateMenuItemDetails(m);
		}
		return totalBill;
	}
}
