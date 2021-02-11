package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Day;
import com.app.pojos.MealType;
import com.app.pojos.MenuItem;

public interface ICanteenMenuService {
	
	List<MenuItem> getMenuForMorning(Day day);
	
	List<MenuItem> getMenuForAfterNoon(Day day, MealType breakfast);
	
	List<MenuItem> getMenuForEvening(Day day, MealType breakfast, MealType lunch);
	
	List<MenuItem> getMenuByDayAndMealType(Day day,MealType mealType);
	
	void deleteMenuItem(int id);
	
	MenuItem updateMenuItemDetails(MenuItem item);
	
	MenuItem addNewItemToMenuList(MenuItem item);
	
	Optional<MenuItem> getMenuById(int id);
}
