package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojo.MyBuddy;
import static utils.DBUtils.fetchDBConnection;

public class MyBuddyImpl implements IMyBuddy {
	
	private Connection connection;
	private PreparedStatement ps1,ps2,ps3,ps4,ps5;
	
	public MyBuddyImpl() throws Exception {
		//fetching connection from DBUtils
		connection=fetchDBConnection();
		//prepare All statements
		ps1=connection.prepareStatement("insert into mybuddies values(?,?,?,?,?)");
		ps2=connection.prepareStatement("select * from mybuddies where email_id=?");
		ps3=connection.prepareStatement("delete from mybuddies where email_id=?");
		ps4=connection.prepareStatement("select * from mybuddies");
		ps5=connection.prepareStatement("select * from mybuddies where dob=?");
	}

	@Override
	public String addNewBuddy(MyBuddy buddy) throws SQLException {
		//setting parameter for query
		ps1.setString(1, buddy.getEmailId());
		ps1.setString(2, buddy.getName());
		ps1.setString(3, buddy.getPhoneNumber());
		ps1.setDate(4, buddy.getDateOfBirth());
		ps1.setString(5, buddy.getCity());
		
		int rowsAffectedCount=ps1.executeUpdate();
		if(rowsAffectedCount==1) {
			return "Record Inserted";
		}
		
		return "Insertion failed";
	}

	@Override
	public MyBuddy searchBuddyByEmail(String emailId) throws SQLException {
		ps2.setString(1, emailId);
		
		try(ResultSet rs=ps2.executeQuery()){
			if(rs.next()) {
				//getting all values from result set then creating new instance of MyBuddy
				return new MyBuddy(rs.getString(1),rs.getString(2) , rs.getString(3), rs.getDate(4), rs.getString(5));
			}
		}
		
		return null;
	}

	@Override
	public String deleteBuddyByEmail(String emailId) throws SQLException {
		ps3.setString(1, emailId);
		
		int rowsAffectedCount=ps3.executeUpdate();
		if(rowsAffectedCount==1) {
			return "Record Deleted";
		}
		
		return "Deletion failed";
	}

	@Override
	public List<MyBuddy> displayAllBuddies() throws SQLException {
		List<MyBuddy> mybuddies=new ArrayList<>();
		
		try(ResultSet rs=ps4.executeQuery()){
			while(rs.next()) {
				mybuddies.add(new MyBuddy(rs.getString(1),rs.getString(2) , rs.getString(3), rs.getDate(4), rs.getString(5)));
			}
		}
		
		return mybuddies;
	}

	@Override
	public List<MyBuddy> displayAllBuddiesByDob(Date dob) throws SQLException {
		ps5.setDate(1, dob);
		List<MyBuddy> mybuddies = new ArrayList<>();

		try (ResultSet rs = ps5.executeQuery()) {
			while(rs.next()) {
				mybuddies.add(new MyBuddy(rs.getString(1),rs.getString(2) , rs.getString(3), rs.getDate(4), rs.getString(5)));
			}
		}
		
		return mybuddies;
	}

	@Override
	public void cleanUp() throws SQLException {
		//close all resources if not null
		if(ps1!=null)
			ps1.close();
		if(ps2!=null)
			ps2.close();
		if(ps3!=null)
			ps3.close();
		if(ps4!=null)
			ps4.close();
		if(ps5!=null)
			ps5.close();
		if(connection!=null)
			connection.close();
		
	}
}

	
