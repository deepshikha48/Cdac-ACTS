package utils;

import java.util.Arrays;
import java.util.HashMap;
import static java.time.LocalDate.of;
import com.app.core.*;
import custom_enum.Category;

public class Collections {
	static HashMap<String, Book> books = new HashMap<>();
	static HashMap<String, Customer> customers = new HashMap<>();

	// creating a list of books that can be available in book shop
	public static HashMap<String, Book> populateBooksData() {
		
		//Science books
		books.put("science1",new Book("science1", Category.valueOf("SCIENCE"), 1000, 3, of(2018, 3, 28), 4));
		books.get("science1").linkAuthorsToBook(Arrays.asList(new Author("Carl Sagan", "carl@gmail.com")));
		books.put("cosmos", new Book("cosmos", Category.valueOf("SCIENCE"), 1900, 3, of(2017, 5, 12), 5));
		books.get("cosmos").linkAuthorsToBook(Arrays.asList(new Author("Napoleon Hill", "nhill@gmail.com")));
		//Meditation books
		books.put("headspace", new Book("headspace", Category.valueOf("MEDITATION"), 1200, 5, of(2019, 8, 4), 4.5));
		books.get("headspace").linkAuthorsToBook(Arrays.asList(new Author("Dan Harris", "dan@gmail.com"),new Author("Jeremy Graves", "jem@gmail.com")));
		books.put("now", new Book("now", Category.valueOf("MEDITATION"), 1300, 2, of(2016, 8, 10), 4.3));
		books.get("now").linkAuthorsToBook(Arrays.asList(new Author("Charlotte Bronte","bront@gmail.com")));
		//Fiction books
		books.put("fiction1", new Book("fiction1", Category.valueOf("FICTION"), 950, 2, of(2017, 9, 1), 3.9));
		books.get("fiction1").linkAuthorsToBook(Arrays.asList(new Author("Jane Austen","jane@gmail.com")));
		books.put("animalfarm", new Book("animalfarm", Category.valueOf("FICTION"), 1050, 2, of(2018, 10, 8), 4.1));
		books.get("animalfarm").linkAuthorsToBook(Arrays.asList(new Author("John Kyle","john@gmail.com")));
		//Finance books
		books.put("finance1",new Book("finance1", Category.valueOf("FINANCE"), 1550, 9, of(2020, 1, 30), 4.5));
		books.get("finance1").linkAuthorsToBook(Arrays.asList(new Author("Jane Austen","jane@gmail.com"),new Author("Dan Brown","brown@gmail.com")));
		books.put("finance2", new Book("finance2", Category.valueOf("FINANCE"), 1700, 1, of(2020, 1, 30), 4.5));
		books.get("finance2").linkAuthorsToBook(Arrays.asList(new Author("Andy Puddicombe","andyP@gmail.com")));
		//Yoga books
		books.put("yoga1", new Book("yoga1", Category.valueOf("YOGA"), 800, 4, of(2020, 2, 18), 4));
		books.get("yoga1").linkAuthorsToBook(Arrays.asList(new Author("B.K.S. Iyengar", "bks@gmail.com")));
		books.put("yoga2",new Book("yoga2", Category.valueOf("YOGA"), 600, 1, of(2015, 8, 9), 3.5));
		books.get("yoga2").linkAuthorsToBook(Arrays.asList(new Author("Anil Kumar", "anil@gmail.com")));
		
		return books;

	}
	
	//creating a list of customers
	public static HashMap<String, Customer> populateCustomerData() {
		
		customers.put("shikha@gmail.com", new Customer("shikha", "shikha@gmail.com", "12345"));
		customers.put("diksha@gmail.com", new Customer("diksha", "diksha@gmail.com", "00000"));
		customers.put("aakash@gmail.com", new Customer("aakash", "aakash@gmail.com", "123123"));
		customers.put("ranbir@gmail.com", new Customer("ranbir", "ranbir@gmail.com", "abc123"));
		customers.put("shalu@gmail.com", new Customer("shalu", "shalu@gmail.com", "786shalu"));
		
		return customers;
		
	}

}
