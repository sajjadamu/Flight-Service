package com.jck.travel.flight.model.dto;

public class AirPortInfo {
	
    private String airPortName;
	
	private String airPortCode;
	
    private String flightNo;
    
    private String departureDate;
    
    private String departureTime;
    
    private String arrivalDate;
    
    private String arrivalTime;
    
    public String getOriginTerminal() {
		return originTerminal;
	}

	public void setOriginTerminal(String originTerminal) {
		this.originTerminal = originTerminal;
	}

	public String getDestinationTerminal() {
		return destinationTerminal;
	}

	public void setDestinationTerminal(String destinationTerminal) {
		this.destinationTerminal = destinationTerminal;
	}

	private String originTerminal; // for galileo

	private String destinationTerminal; // for galileo
	
	public String getAirPortName() {
		return airPortName;
	}

	public void setAirPortName(String airPortName) {
		this.airPortName = airPortName;
	}

	public String getAirPortCode() {
		return airPortCode;
	}

	public void setAirPortCode(String airPortCode) {
		this.airPortCode = airPortCode;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
}
