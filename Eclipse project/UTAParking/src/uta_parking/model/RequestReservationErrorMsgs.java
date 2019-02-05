package uta_parking.model;

public class RequestReservationErrorMsgs {

	private String errorMsg;
	private String ridError;
	private String parking_area_nameError;
	private String parking_type_idError;
	private String floorError;
	private String spot_numberError;
	private String options_idError;
	private String user_idError;
	private String start_timeError;
	private String durationError;
	private String costError;
	private String statusError;
	
	public RequestReservationErrorMsgs(){
	 this.ridError = "";
	 this.parking_area_nameError = "";
	 this.parking_type_idError = "";
	 this.floorError = "";
	 this.spot_numberError = "";
	 this.options_idError = "";
	 this.user_idError = "";
	 this.start_timeError = "";
	 this.durationError = "";
	 this.costError = "";
	 this.statusError = "";
	}
	
	
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String action) {
		if (action.equals("requestReservation")) {
			if ( !ridError.equals("") || 
				 !parking_area_nameError.equals("") || 
				 !parking_type_idError.equals("") || 
				 !floorError.equals("") || 
				 !spot_numberError.equals("") || 
				 !options_idError.equals("") || 
				 !user_idError.equals("") || 
				 !start_timeError.equals("") || 
				 !durationError.equals("") || 
				 !costError.equals("") || 
				 !statusError.equals(""))
				
				this.errorMsg="Please correct the following errors";
		}
					
	}
	
	public String getIdReservationError() {
		return ridError;
	}
	public void setIdReservationError(String ridError) {
		this.ridError = ridError;
	}
	
	public String getParking_are_nameError() {
		return parking_area_nameError;
	}
	public void setParking_area_nameError(String parking_area_nameError) {
		this.parking_area_nameError = parking_area_nameError;
	}
	public String getParking_type_idError() {
		return parking_type_idError;
	}
	public void setParking_type_idError(String parking_type_idError) {
		this.parking_type_idError = parking_type_idError;
	}
	public String getFloorError() {
		return floorError;
	}
	public void setFloorError(String floorError) {
        this.floorError = floorError;
	}
	
	public String getSpot_numberError() {
		return spot_numberError;
	}
	public void setSpot_numberError(String spot_numberError) {
        this.spot_numberError = spot_numberError;
	}
	
	public String getOptions_idError() {
		return options_idError;
	}
	public void setOptions_idError(String options_idError) {
		this.options_idError =  options_idError;
	}
	
	public String getUser_idError() {
		return user_idError;
	}
	public void setUser_idError(String user_idError) {
		this.user_idError =  user_idError;
	}
	
	public String getStart_timeError() {
		return start_timeError;
	}
	public void setStart_timeError(String start_timeError) {
		this.start_timeError = start_timeError;
	}
	
	public String getDurationError() {
		return durationError;
	}
	public void setDurationError(String durationError) {
		this.durationError = durationError;
	}
	
	public String getCostError() {
		return costError;
	}
	public void setCostError(String costError) {
		this.costError = costError;
	}
	
	public String getStatusError() {
		return statusError;
	}
	public void setStatusError(String statusError) {
		this.statusError = statusError;
	}

}