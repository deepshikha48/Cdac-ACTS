package com.app.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.app.pojos.Day;
import com.app.pojos.MealType;
import com.app.pojos.MenuItem;
import com.app.service.ICanteenMenuService;

@RestController
@RequestMapping("/menu")
@CrossOrigin("http://localhost:4200")

public class CanteenMenuController {

	@Autowired
	private ICanteenMenuService service;

	@GetMapping
	public ResponseEntity<?> getTodaysMenu() {

		Day day = Day.valueOf(LocalDate.now().getDayOfWeek().toString());
		int time = LocalTime.now().getHour();
		List<MenuItem> items = new ArrayList<>();

		if (time >= 8 && time < 12)
			items = service.getMenuForMorning(day);
		if (time >= 12 && time <= 15)
			items = service.getMenuForAfterNoon(day, MealType.BREAKFAST);
		else if (time > 15 && time <= 22)
			items = service.getMenuForEvening(day, MealType.BREAKFAST, MealType.LUNCH);

		if (items.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
		}
		return new ResponseEntity<>(items, HttpStatus.OK);
	}

	@GetMapping("/{day}/{mealType}")
	public ResponseEntity<?> getMenuList(@PathVariable String day, @PathVariable String mealType) {

		List<MenuItem> items = new ArrayList<>();
		items = service.getMenuByDayAndMealType(Day.valueOf(day), MealType.valueOf(mealType));

		if (items.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
		}
		return new ResponseEntity<>(items, HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public void deleteMenuItemDetails(@PathVariable int id) {

		try {
			service.deleteMenuItem(id);
		} catch (RuntimeException e) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST); // 400
		}
	}

	@PutMapping
	public ResponseEntity<?> updateMenuItemDetails(@RequestBody MenuItem menuItem) {
		
		Optional<MenuItem> tempItem = service.getMenuById(menuItem.getId());
		if ( tempItem.isPresent())
			return ResponseEntity.ok(service.updateMenuItemDetails(menuItem));
		throw new HttpClientErrorException(HttpStatus.FORBIDDEN);//403
		
	}

	@PostMapping
	public ResponseEntity<?> addNewMenuItem(@RequestBody MenuItem menuItem) {
		try {

			return new ResponseEntity<>(service.addNewItemToMenuList(menuItem), HttpStatus.CREATED);

		} catch (Exception e) {
			throw new HttpClientErrorException(HttpStatus.NOT_ACCEPTABLE);//406
		}

	}

	@GetMapping("/days")
	public ResponseEntity<?> getAllDays() {
		Day[] names = Day.values();
		String[] days = new String[names.length];
		for (int i = 0; i < names.length; i++) {
			days[i] = names[i].name();
		}

		return new ResponseEntity<>(days, HttpStatus.OK);
	}

	@GetMapping("/mealtypes")
	public ResponseEntity<?> getAllMealTypes() {
		MealType[] names = MealType.values();
		String[] mealTypes = new String[names.length];
		for (int i = 0; i < names.length; i++) {
			mealTypes[i] = names[i].name();
		}

		return new ResponseEntity<>(mealTypes, HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<?> getMenuItemById(@PathVariable int id) {
		Optional<MenuItem> menuItem = service.getMenuById(id);
		if (menuItem.isPresent())
			return ResponseEntity.ok(menuItem.get());
		throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);//400
	}

}
