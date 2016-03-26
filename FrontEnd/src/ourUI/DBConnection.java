package ourUI;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class DBConnection {
	
	Connection conn = null;
		
	
	public DBConnection(String hosting, String username, String password){
		try{
			 conn = DriverManager.getConnection(hosting, username, password);
			 System.out.println("Successfully connecting to Database ... ");
		} catch(Exception e){
			System.out.println("Failed when connecting to Database ...");
		}		
	}
	
	public void executeQuery(String query){
		try {
			//
			Statement myStmt = conn.createStatement();
			// get result table set
			ResultSet myRs = myStmt.executeQuery(query);
			// print out the table 
//			System.out.println(myRs.getString("customerRef"));
//			while(myRs.next()){
//				// fill in column name
//				System.out.println(myRs.getString("customerRef"));
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public ResultSet getCustomer(String customerRef){
		try {
			Statement myStmt = conn.createStatement();
			return myStmt.executeQuery("SELECT * FROM customers WHERE customerRef = '" + customerRef +"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void addCustomer(String fName, String lName, String IDnumber, String emailAddress, String country){
		try {
			// create new Statement
			Integer newCustomerRef;
			Statement myStmt = conn.createStatement();
			ArrayList<Integer> customerRefList = new ArrayList<Integer>();
			ResultSet customerAddressSet = myStmt.executeQuery("SELECT custo"
					+ "merRef FROM firstschema.customers"
					+ "");
			while(customerAddressSet.next()){
				customerRefList.add(Integer.parseInt(customerAddressSet.getString("customerRef")));
			}
			newCustomerRef = Collections.max(customerRefList) + 1;
			// the entity with need to be added
			String entity = newCustomerRef + ",'" + fName + "','" + lName + "','" + IDnumber + "','" + emailAddress + "','" + country +"'";
			// the query for inserting
			String query = "INSERT INTO customers"
					+ "(customerRef, fName, lName, IDnumber, emailAddress, country)"
					+ "VALUES(" + entity + ")"; 
			// 
			myStmt.executeUpdate(query);
			System.out.println("New Customer Insert Completed");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void addRooms(Integer roomNumber, String roomType, Integer capacity, double price, Integer customerRef){
		try {
			// create new Statement
			Statement myStmt = conn.createStatement();
			// the entity with need to be added
			String entity = roomNumber + ",'" + roomType + "'," + capacity + "," + price + "," + customerRef;
			// the query for inserting
			String query = "INSERT INTO room"
					+ "(roomNumber, roomType, capacity, Price, customerRef)"
					+ "VALUES(" + entity + ")"; 
			myStmt.executeUpdate(query);
			System.out.println("New Room Insert Completed");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void addReservation(Integer roomNumber, String customerRef, Integer guestNum, String InDate, String OutDate){
		try {
			// create new Statement
			Statement myStmt = conn.createStatement();
			// the entity with need to be added
			String entity = roomNumber + ",'" + customerRef + "'," + guestNum + "," + InDate + "," + OutDate;
			// the query for inserting
			String query = "INSERT INTO room"
					+ "(roomNumber, customerRef, guestNum, InDate, OutDate)"
					+ "VALUES(" + entity + ")"; 
			myStmt.executeUpdate(query);
			System.out.println("New Resevation Insert Completed");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void addInvoice(Integer invoiceNumber, String customerRef, double amount, String ispaid, String payingMethod, String comments){
		try {
			// create new Statement
			Statement myStmt = conn.createStatement();
			// the entity with need to be added
			String entity = invoiceNumber + ",'" + customerRef + "'," + amount + ",'" + ispaid + "','" + payingMethod +"','"+ comments+"'";
			// the query for inserting
			String query = "INSERT INTO invoice"
					+ "(invoiceNumber, customerRef, amount, ispaid, payingMethod, comments)"
					+ "VALUES(" + entity + ")"; 
			myStmt.executeUpdate(query);
			System.out.println("New invoice Insert Completed");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateMethod(String Table, String Category, Object data, String conditionCategory, String conditionData){
		try {
			// create new Statement
			Statement myStmt = conn.createStatement();
			String query = "UPDATE "+ Table + " SET "
					+ Category + "='" + data +"' WHERE " + conditionCategory + "='" + conditionData + "'" ;
			System.out.println(query);
			myStmt.executeUpdate(query);
			System.out.println(Table +" info updated Completed");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteMethod(String Table, String Category, Object data, String conditionCategory, String conditionData){
		try {
			// create new Statement
			Statement myStmt = conn.createStatement();
			String query = "DELETE " + Table+" FROM "
					+ Category + "='" + data +"' WHERE " + conditionCategory + "='" + conditionData + "'" ;
			System.out.println(query);
			myStmt.executeUpdate(query);
			System.out.println("Customer info delete Completed");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
//		  try { 
//			   Class.forName("com.mysql.jdbc.Driver");   //¼ÓÔØMYSQL JDBCÇý¶¯³ÌÐò  
//			   //Class.forName("org.gjt.mm.mysql.Driver"); 
//			   System.out.println("Success loading Mysql Driver!"); 
//			  } 
//			  catch (Exception e) { 
//			   System.out.print("Error loading Mysql Driver!"); 
//			   e.printStackTrace(); 
//			  }
		DBConnection myDB = new DBConnection("jdbc:mysql://localhost:3306/firstSchema", "root", "260225towncenter");
		//
		myDB.executeQuery("SELECT * FROM firstSchema.customers;");
		myDB.addCustomer("FIRST","LAST","1234","hellogmail.com","ca");
		//myDB.addRooms(234,"window",3, 899.99, 99);
//		myDB.updateCustomer("customerRef","888","customerRef", "B3");
//		myDB.executeQuery("SELECT * FROM firstschema.customers;");
//		myDB.addInvoice(22334,"98999",334.44,"true", "visa","");
		//myDB.updateCustomer("invoiceNumber","888","customerRef", "B3");
	}
}

