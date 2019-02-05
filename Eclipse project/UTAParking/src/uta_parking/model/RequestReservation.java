package uta_parking.model;

import java.io.Serializable;

import uta_parking.data.ReservationDAO;

public class RequestReservation implements Serializable{

	private static final long serialVersionUID = 3L;
	private String rid;
	private String parking_area_name;
	private String parking_type_id;
	private String floor;
	private String spot_number;
	private String options_id;
	private String user_id;
	private String start_time;
	private String duration;
	private String cost;
	private String status;
	
	public RequestReservation(){
	 this.rid = "";
	 this.parking_area_name = "";
	 this.parking_type_id = "";
	 this.floor = "";
	 this.spot_number = "";
	 this.options_id = "";
	 this.user_id = "";
	 this.start_time = "";
	 this.duration = "";
	 this.cost = "";
	 this.status = "";
	}
	
	public void setReservation(String rid, String parking_area_name,String parking_type_id, String floor, String spot_number
			,String options_id, String user_id, String start_time, String duration, String cost, String status) {
		
		setIdReservation(rid);
		setParking_area_name(parking_area_name);
		setParking_type_id(parking_type_id);
		setFloor(floor);
		setSpot_number(spot_number);
		setOptions_id(options_id);
		setUser_id(user_id);
		setStart_time(start_time);
		setDuration(duration);
		setCost(cost);
		setStatus(status);
	}
	
	public String getIdReservation() {
		return rid;
	}
	public void setIdReservation(String rid) {
		this.rid = rid;
	}
	
	public String getParking_area_name() {
		return parking_area_name;
	}
	public void setParking_area_name(String parking_area_name) {
		this.parking_area_name = parking_area_name;
	}
	public String getParking_type_id() {
		return parking_type_id;
	}
	public void setParking_type_id(String parking_type_id) {
		this.parking_type_id = parking_type_id;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
        this.floor = floor;
	}
	
	public String getSpot_number() {
		return spot_number;
	}
	public void setSpot_number(String spot_number) {
        this.spot_number = spot_number;
	}
	
	public String getOptions_id() {
		return options_id;
	}
	public void setOptions_id(String options_id) {
		this.options_id =  options_id;
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id =  user_id;
	}
	
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public void validateReservation (String action, RequestReservation request_reservation, RequestReservationErrorMsgs errorMsgs) {
		if (action.equals("requestReservation")) {
		
			errorMsgs.setStart_timeError(validateStart_time(action,request_reservation.getStart_time()));
			
			errorMsgs.setDurationError(validateDuration(action,request_reservation.getDuration(),
															request_reservation.getStart_time(), 
															request_reservation.getUser_id()));			
			errorMsgs.setErrorMsg(action);
			
		}
		
	}

	private String validateStart_time(String action, String start_time) {
		String result="";
		
		// GET SYSTEM TIME
		// CANNOT RESERVE MORE THAN 15 MIN AFTER MAX 9:03 FOR 9:15 (INCLUDED 3 MIN FOR MERCY :) )
		// TIME starts by the hour and is in 15 min increments
		// Start time min is next 15 min increments
		//start time max is 23:45
		//Start time cannot overlap with existing reservations
		
		
		return result;
	}

	
	private String validateDuration(String action,String duration, String start_time, String user_id) {
		String result="";
		int alreadyReservedForTheDay=ReservationDAO.reservedForTheDay(user_id);
		int min = 15;
		int max = 180 - alreadyReservedForTheDay;

// Duration must be :
//			- a number
//			- minimum is 15mins
//			- maximum is : 180(3hours) - alreadyReservedTimeForTheDay 
//			- in increments of 15mins : duration number % 15 = 0
//			- duration should not span over next day i.e : startTime + duration <= 00:00 of the next day	
			
			if (!isTextAnInteger(duration))
				result="Duration of the reservation must be a number!";
			else 
			{
				long _duration = Long.parseLong(duration);
				
				if (!isBetween(_duration, min,max))
					result="Minimum is 15minutes, the maximum 180 - minutes you've already reserved today";
				
				else {
					
					if (!isDivisibleBy(_duration, min))
						result="Duration must be in intervals of 15mins";
					
					else 
						if(!maxDuration(start_time, _duration))
							result="Start time + duration cannot exceed midnight.";

				}
				
			}
		return result;		
	}
	
	

//	This section is for general purpose methods used internally in this class
	
	
/*	
	private boolean stringSize(String string, int min, int max) {
		return string.length()>=min && string.length()<=max;
	}
*/
	
	
	
	private boolean isTextAnInteger (String string) {
        boolean result;
		try
        {
            Long.parseLong(string);
            result=true;
        } 
        catch (NumberFormatException e) 
        {
            result=false;
        }
		return result;
	}
	
	private boolean maxDuration(String start_time, long _duration) {
		boolean result;
		long start_time_minutes=0;
		
		//CONVERT TO MINUTES
		// long _start_time = Long.parseLong(start_time);
		// start_time_minutes = _start_time * 60;
		//1440 is the minutes there are in a single day
		
		if (start_time_minutes + _duration >1440) result = false;
		else result= true;
		
		
		return result;
	}
			
	private boolean isDivisibleBy (long number, int divisor) {
        boolean result;
		
        if ((number % divisor) == 0) result = true;
        else result =false;
        
		return result;
	}
	
	private boolean isBetween(long _duration, int min,int max)
	{
		 boolean result;
			
	        if (_duration < min || _duration > max ) result = false;
	        else result =true;
	        
			return result;
		
		
		
		
	}
}