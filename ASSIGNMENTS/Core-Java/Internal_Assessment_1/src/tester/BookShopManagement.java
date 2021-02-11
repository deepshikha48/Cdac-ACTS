package tester;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.app.core.Book;
import com.app.core.BookShop;
import com.app.core.Customer;

import static utils.Collections.*;
import static utils.ValidationRules.*;

public class BookShopManagement {

	public static void main(String[] args) {

		// try with resource
		try (Scanner sc = new Scanner(System.in)) {

			// creating an instance of book shop
			BookShop shop = new BookShop(populateCustomerData(), populateBooksData());
			// customer reference
			Customer customer = null;

			boolean exit = false;
			while (!exit) {
				System.out.println("1.Login");
				System.out.println("2.Add a book to a cart");
				System.out.println("3.Remove a book from a cart");
				System.out.println("4.Show cart contents");
				System.out.println("5.Logout");
				System.out.println("Enter your choice");
				try {
					switch (sc.nextInt()) {

					// Login
					case 1:
						// if customer is null then no one has logged in yet
						if (customer == null) {
							System.out.println("Enter email and password");
							customer = login(sc.next(), sc.next(), shop);
							System.out.println("WELCOME " + customer.getName().toUpperCase() + " !!");
							customer.addCart();// adding empty cart
							// display books in book shop
							System.out.println("AVAILABLE BOOKS ARE: ");
							for (Book book : shop.getBooks().values())
								System.out.println(book);
						} else
							System.out.println("Only one user can login at a time");
						break;

					// add books to cart
					case 2:
						isLogin(customer);// check if customer as logged in or not
						System.out.println("Enter book title and quantity");
						fillCart(sc.next(), validateQuantity(sc.nextInt()), shop, customer);
						System.out.println("Added to cart");
						break;

					// remove books from cart
					case 3:
						isLogin(customer);// check if customer as logged in or not
						System.out.println("Enter book title and quantity");
						removeBookFromCart(sc.next(), validateQuantity(sc.nextInt()), customer);
						System.out.println("Removed from cart");
						break;

					// display cart contents
					case 4:
						isLogin(customer);// check if customer as logged in or not
						HashMap<String, Book> books = customer.getCart();
						if (books.size() == 0)// check for empty cart
							System.out.println("cart is empty");
						else {
							for (Book tempBook : books.values())
								System.out.println(tempBook);
						}
						break;

					// logout
					case 5:
						isLogin(customer);// check if customer as logged in or not
						HashMap<String, Book> cartBooks = customer.getCart();
						double sum = 0;
						for (Book book : cartBooks.values()) {
							// display title of books in cart
							System.out.println(book.getTitle());
							// generating total bill
							sum = sum + (book.getQuantity() * book.getPrice());
						}
						System.out.println("Your cart total: " + sum);
						// exit condition
						exit = true;
						break;

					// invalid choice
					default:
						System.out.println("Invalid choice");
						break;
					}

				} catch (InputMismatchException e) {
					System.out.println("invalid input");
				} catch (Exception e) {
					System.out.println(e.getMessage());
					;
				}
				sc.nextLine();
			}
		}
	}

}
