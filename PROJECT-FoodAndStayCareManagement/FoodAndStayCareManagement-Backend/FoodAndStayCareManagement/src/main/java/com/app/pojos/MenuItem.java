package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "menu_items")

public class MenuItem extends BaseEntity {

	@Column(name = "item_name", nullable = false, length = 15)
	private String itemName;

	@Column(name = "total_quantity", nullable = false)
	private int totalQuantity;

	@Column(length = 100)
	private String description;

	@Column(nullable = false)
	private double price;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "meal_type", nullable = false, length = 20)
	private MealType mealType;

	@Enumerated(EnumType.STRING)
	@Column(name = "day", nullable = false, length = 20)
	private Day day;
	
	public MenuItem() {
		System.out.println("In Constructor of: "+getClass().getName());
	}

	public MenuItem(String itemName, int totalQuantity, String description, double price, MealType mealType, Day day) {
		super();
		this.itemName = itemName;
		this.totalQuantity = totalQuantity;
		this.description = description;
		this.price = price;
		this.mealType = mealType;
		this.day = day;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public MealType getMealType() {
		return mealType;
	}

	public void setMealType(MealType mealType) {
		this.mealType = mealType;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	

	@Override
	public String toString() {
		return "MenuItem [Id=" + getId() + "itemName=" + itemName + ", totalQuantity=" + totalQuantity + ", description=" + description
				+ ", price=" + price + ", mealType=" + mealType + ", day=" + day + "]";
	}
	
	
}
