package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import pojo.MyBuddy;

public interface IMyBuddy {

	String addNewBuddy(MyBuddy buddy) throws SQLException;
	MyBuddy searchBuddyByEmail(String emailId) throws SQLException;
	String deleteBuddyByEmail(String emailId) throws SQLException;
	List<MyBuddy> displayAllBuddies() throws SQLException;
	List<MyBuddy> displayAllBuddiesByDob(Date dob) throws SQLException;
	void cleanUp() throws SQLException;
	
	
}
