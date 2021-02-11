package tester;

import static java.sql.Date.valueOf;
import static utils.ValidationRules.validateDateOfBirth;
import static utils.ValidationRules.validateEmail;
import static utils.ValidationRules.validatePhoneNumber;
import java.util.List;
import java.util.Scanner;
import dao.MyBuddyImpl;
import pojo.MyBuddy;

public class MyBuddiesManagement {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			
			//creating instance of dao 
			MyBuddyImpl dao = new MyBuddyImpl();

			boolean exit = false;
			while (!exit) {
				try {
					System.out.println("1.Add new buddy");
					System.out.println("2.Search Buddy by Email id");
					System.out.println("3.Delete Buddy by Email id");
					System.out.println("4.Display all my buddies");
					System.out.println("5.Display all buddies by date");
					System.out.println("6.Exit");

					switch (sc.nextInt()) {
					
					//Add new Buddy
					case 1:

						System.out.println("Enter Your Buddies details: ");
						System.out.println("Enter EmailId , Name , Phoneno(length=10) , Dob(yyyy-mm-dd) , city");
						System.out.println(dao.addNewBuddy(new MyBuddy(validateEmail(sc.next()), sc.next(),
								validatePhoneNumber(sc.next()), validateDateOfBirth(sc.next()), sc.next())));
						break;

					//Search By email
					case 2:

						System.out.println("Enter EmailId");
						MyBuddy myBuddy = dao.searchBuddyByEmail(validateEmail(sc.next()));
						if (myBuddy == null) {
							System.out.println("Record Not Found");
						} else {
							System.out.println(myBuddy);
						}
						break;

					//Delete by email
					case 3:

						System.out.println("Enter EmailId");
						System.out.println(dao.deleteBuddyByEmail(validateEmail(sc.next())));
						break;

					//display all buddies
					case 4:

						List<MyBuddy> allBuddies = dao.displayAllBuddies();
						if (allBuddies.isEmpty()) {
							System.out.println("No Records");
						} else {
							allBuddies.forEach(buddy -> System.out.println(buddy));
						}
						break;

					//display all buddies by date of birth
					case 5:
						System.out.println("Enter dob");
						List<MyBuddy> buddiesByDob = dao.displayAllBuddiesByDob(valueOf(sc.next()));
						if (buddiesByDob.isEmpty()) {
							System.out.println("No Records");
						} else {
							buddiesByDob.forEach(buddy -> System.out.println(buddy));
						}
						break;

					//clean up all resources before exit
					case 6:
						dao.cleanUp();
						exit = true;
						break;

					//invalid choice
					default:
						System.out.println("Invalid choice try again");
						break;
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

}
