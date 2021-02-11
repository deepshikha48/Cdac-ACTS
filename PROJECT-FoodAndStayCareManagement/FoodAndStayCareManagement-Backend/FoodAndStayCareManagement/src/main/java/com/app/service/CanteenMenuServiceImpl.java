package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Day;
import com.app.pojos.MealType;
import com.app.pojos.MenuItem;
import com.app.repository.CanteenMenuRepository;

@Service
@Transactional
public class CanteenMenuServiceImpl implements ICanteenMenuService{
	
	@Autowired 
	private CanteenMenuRepository repo;
	private Optional<MenuItem> item;

	@Override
	public List<MenuItem> getMenuForMorning(Day day) {
		
		return repo.findByDay(day);
	}

	@Override
	public List<MenuItem> getMenuForAfterNoon(Day day, MealType breakfast) {
		
		return repo.findByDayAndMealTypeExceptBreakfast(day, breakfast);
	}

	@Override
	public List<MenuItem> getMenuForEvening(Day day, MealType breakfast, MealType lunch) {
		
		return repo.findByDayAndMealTypeExceptBreakfastLunch(day, breakfast, lunch);
	}
	
	@Override
	public List<MenuItem> getMenuByDayAndMealType(Day day, MealType mealType) {
		
		return repo.findByDayAndMealType(day, mealType);
	}

	@Override
	public void deleteMenuItem(int id) {
			repo.deleteById(id);		
	}

	@Override
	public MenuItem updateMenuItemDetails(MenuItem menuItem) {
		
			return repo.save(menuItem); 
		
	}

	@Override
	public MenuItem addNewItemToMenuList(MenuItem item) {
		
		return repo.save(item);
	}

	@Override
	public Optional<MenuItem> getMenuById(int id) {
		return repo.findById(id);
	}


	
}
