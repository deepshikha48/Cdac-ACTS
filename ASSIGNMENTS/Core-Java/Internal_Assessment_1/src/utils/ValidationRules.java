package utils;

import com.app.core.Book;
import com.app.core.BookShop;
import com.app.core.Customer;
import custom_exception.InvalidInputException;

public class ValidationRules {

	private static Book book;

	// Email validation
	public static String validateEmail(String email) throws InvalidInputException {
		if (!email.contains("@") || (!email.endsWith(".com")))
			throw new InvalidInputException("Invalid email");
		return email;

	}

	// Password validation
	public static String validatePassword(String password) throws InvalidInputException {
		if (password.length() < 5)// minimum length 5
			throw new InvalidInputException("Password must be min 8 chars long");
		return password;
	}

	// Rating can be 1-5
	public static double validateRating(double rating) throws InvalidInputException {
		if (rating > 5 || rating < 1)
			throw new InvalidInputException("Rating can be 1-5");
		return rating;
	}

	// Quantity validation
	public static int validateQuantity(int quantity) throws InvalidInputException {
		if (quantity < 1)
			throw new InvalidInputException("quantity can't be less than 1");
		return quantity;
	}

	// Customer Login
	public static Customer login(String email, String password, BookShop shop) throws InvalidInputException {
		Customer customer = shop.getCustomers().get(email);// return customer data by searching on email
		if (customer != null && customer.getPassword().equals(password))// check if password is correct
			return customer;
		throw new InvalidInputException("Wrong inputs...LOGIN FAILED !!");
	}

	// if books exists in book shop
	public static Book ifBookExistsInShop(BookShop shop, String bookTitle) throws InvalidInputException {
		book = shop.getBooks().get(bookTitle);// search a book on the basis of title(PK)
		if (book == null)
			throw new InvalidInputException("No such book in book shop");
		return book;

	}

	// check if customer has logged in or not
	public static void isLogin(Customer customer) throws InvalidInputException {
		if (customer == null)
			throw new InvalidInputException("Need to login first");
	}

	// validating the quantity to add a book into cart
	public static void checkQuantity(int quantity, Book bookInShop, Book bookInCart) throws InvalidInputException {
		if (bookInCart == null && bookInShop.getQuantity() < quantity)
			throw new InvalidInputException("Available But in less quantity");
		if (bookInCart != null && bookInShop.getQuantity() < (bookInCart.getQuantity() + quantity))
			throw new InvalidInputException(
					"you can add " + (bookInShop.getQuantity() - bookInCart.getQuantity()) + " more book of such type");
	}

	// Add book to cart
	public static void fillCart(String bookTitle, int quantity, BookShop shop, Customer customer)
			throws InvalidInputException {
		Book bookInShop = ifBookExistsInShop(shop, bookTitle);
		Book bookInCart = customer.getCart().get(bookTitle);
		checkQuantity(quantity, bookInShop, bookInCart);
		if (bookInCart == null)// adding book to cart if not present
			customer.getCart().put(bookTitle, new Book(bookTitle, bookInShop.getCategory(), bookInShop.getPrice(),
					quantity, bookInShop.getPublishDate(), bookInShop.getRating()));
		else
			bookInCart.setQuantity(book.getQuantity() + quantity);// if present then update quantity

	}

	// Remove book from cart
	public static void removeBookFromCart(String bookTitle, int quantity, Customer customer)
			throws InvalidInputException {
		book = customer.getCart().get(bookTitle);
		if (book == null)// if no such book in cart
			throw new InvalidInputException("No such book in cart");
		else if (book != null && quantity >= book.getQuantity())
			customer.getCart().remove(bookTitle);
		else
			book.setQuantity(book.getQuantity() - quantity);// decreasing the quantity

	}

}
