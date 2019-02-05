package uta_parking.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uta_parking.util.SQLConnection;
import uta_parking.model.RequestReservation;
public class ReservationDAO {
	

	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	private static ArrayList<RequestReservation> ReturnMatchingReservationsList (String queryString) {
		ArrayList<RequestReservation> reservationListInDB = new ArrayList<RequestReservation>();
		
			Statement stmt = null;
			Connection conn = SQLConnection.getDBConnection();  
			
		try {
			stmt = conn.createStatement();
			ResultSet reservationList = stmt.executeQuery(queryString);
			
			//Looping through the whole result of query and creation an object for each row of DB 
			while (reservationList.next()) {
				RequestReservation reservation = new RequestReservation(); 
				
				//get attribute value in DB
				reservation.setIdReservation(reservationList.getString("rid"));
				reservation.setParking_area_name(reservationList.getString("parking_area_name"));
				reservation.setParking_type_id(reservationList.getString("parking_type_id"));
				reservation.setFloor(reservationList.getString("floor"));
				reservation.setSpot_number(reservationList.getString("spot_number"));
				reservation.setOptions_id(reservationList.getString("options_id"));
				reservation.setUser_id(reservationList.getString("user_id"));
				reservation.setStart_time(reservationList.getString("start_time"));
				reservation.setDuration(reservationList.getString("duration"));
				reservation.setCost(reservationList.getString("cost"));
				reservation.setStatus(reservationList.getString("status"));
				
				//Print each reservation details
				System.out.println(reservation.getIdReservation()+  "  " + 
				reservation.getParking_area_name()+  "  " +
				reservation.getParking_type_id()+  "  " +
				reservation.getFloor()+  "  " +
				reservation.getSpot_number()+  "  " +
				reservation.getOptions_id()+  "  " +
				reservation.getUser_id()+  "  " +
				reservation.getStart_time()+  "  " +
				reservation.getDuration()+  "  " +
				reservation.getCost()+  "  " +
				reservation.getStatus());
				
				reservationListInDB.add(reservation);	
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			};
		}
		return reservationListInDB;
	}
	
	private static void StoreListinDB (RequestReservation reservation,String queryString) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			
			String insertReservation = queryString + " VALUES ('"+ 
			reservation.getIdReservation()   + "','" +  
			reservation.getParking_area_name()   + "','" +  
			reservation.getParking_type_id()   + "','" +  
			reservation.getFloor()   + "','" +  
			reservation.getSpot_number()   + "','" +  
			reservation.getOptions_id()   + "','" +  
			reservation.getUser_id()   + "','" +  
			reservation.getStart_time()   + "','" +  
			reservation.getDuration()   + "','" +  
			reservation.getCost()   + "','" +  
			reservation.getStatus()+ "','" + 
			 " SYSDATE())";
			
			
			stmt.executeUpdate(insertReservation);
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}};
	}
	
	public static void insertRequestReservation(RequestReservation requestReservation) {  
		StoreListinDB(requestReservation,"INSERT INTO RESERVATION (idcompany,company_name,phone,email,date_ins) ");
		
	
	}
	
	public static ArrayList<RequestReservation>  listAllReservations() {  
			return ReturnMatchingReservationsList(" SELECT * from RESERVATION ORDER BY start_time");
	}
	
	
	public static int reservedForTheDay(String user_id) {
		
		//get list of reservation for a particular user for TODAY.
		// Add up durations
		// Return total

		
		return 0;
	}
	
	/*
	
	//search companies
	public static ArrayList<RequestReservation>  searchCompanies(String RequestReservationname)  {  
			return ReturnMatchingCompaniesList(" SELECT * from RequestReservation WHERE RequestReservation_name LIKE '%"+RequestReservationname+"%' ORDER BY idRequestReservation");
	}
	
	//determine if RequestReservationID is unique
	public static Boolean RequestReservationIDunique(String idComp)  {  
			return (ReturnMatchingCompaniesList(" SELECT * from RequestReservation WHERE IDRequestReservation = '"+idComp+"' ORDER BY RequestReservation_name").isEmpty());
	}
	//search RequestReservation with RequestReservation ID
	public static ArrayList<RequestReservation>   searchRequestReservation (String idComp)  {  
			return ReturnMatchingCompaniesList(" SELECT * from RequestReservation WHERE IDRequestReservation = '"+idComp+"' ORDER BY RequestReservation_name");
	}
	*/
	

}