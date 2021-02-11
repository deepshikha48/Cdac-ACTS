package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Day;
import com.app.pojos.MealType;
import com.app.pojos.MenuItem;


public interface CanteenMenuRepository extends JpaRepository<MenuItem, Integer>{
	
	List<MenuItem> findByDay(Day day);
	
	@Query("select m from MenuItem m where m.day=:day and m.mealType<>:breakfast")
	List<MenuItem> findByDayAndMealTypeExceptBreakfast(@Param("day") Day day , @Param("breakfast") MealType breakfast);
	
	@Query("select m from MenuItem m where  m.day=:day and m.mealType<>:breakfast and  m.mealType<>:lunch")
	List<MenuItem> findByDayAndMealTypeExceptBreakfastLunch(@Param("day")Day day,@Param("breakfast")MealType breakfast,@Param("lunch")MealType lunch);
	
	List<MenuItem> findByDayAndMealType(Day day,MealType mealType);

}
