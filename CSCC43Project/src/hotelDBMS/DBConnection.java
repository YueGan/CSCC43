package hotelDBMS;

import java.sql.*;

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
			while(myRs.next()){
				// fill in column name
				System.out.println(myRs.getString("fName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public void addCustomer(Integer refNumber, String fName, String lName, String IDnumber, String emailAddress, String country){
		try {
			// create new Statement
			Statement myStmt = conn.createStatement();
			// the entity with need to be added
			String entity = refNumber + ",'" + fName + "','" + lName + "','" + IDnumber + "','" + emailAddress + "','" + country +"'";
			// the query for inserting
			String query = "INSERT INTO customers"
					+ "(refNumber, fName, lName, IDnumber, emailAddress, country)"
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
//		myDB.executeQuery("SELECT * FROM firstschema.customers;");
		//myDB.addCustomer(9,"FIRST","LAST","1234","hellogmail.com","ca");
		//myDB.addRooms(234,"window",3, 899.99, 99);
//		myDB.updateCustomer("customerRef","888","customerRef", "B3");
//		myDB.executeQuery("SELECT * FROM firstschema.customers;");
		myDB.addInvoice(22334,"98999",334.44,"true", "visa","");
		//myDB.updateCustomer("invoiceNumber","888","customerRef", "B3");
	}
}

