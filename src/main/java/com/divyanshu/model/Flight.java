package com.divyanshu.model;



public class Flight
{
    private String flightId;
    private String companyName;
    private String sourceCity;
    private String destinationCity;
    private double cost;
    private double discount;
    private String arrivalDate;
    private String arrivalTime;
    private String departureTime;
    private String departureDate;
    private String offerStartDate;
    private String offerStartTime;
    private String offerEndDate;
    private String offerEndTime;
    private Boolean offerEntered;
    public Flight(Flight flight2) {
		this.flightId = flight2.getFlightId();
		this.sourceCity = flight2.getSourceCity();
		this.destinationCity = flight2.getDestinationCity();
		this.cost = flight2.getCost();
		this.discount = flight2.getDiscount();
		this.arrivalDate = flight2.getArrivalDate();
		this.departureDate = flight2.getDepartureDate();
		this.arrivalTime = flight2.getArrivalTime();
		this.departureTime = flight2.getDepartureTime();
		this.offerEntered = flight2.getOfferEntered();
		this.offerStartDate = flight2.getOfferStartDate();
		this.offerEndDate = flight2.getOfferEndDate();
		this.offerEndTime = flight2.getOfferEndTime();
		this.offerStartTime = flight2.getOfferStartTime();
		this.companyName=flight2.getCompanyName();

	}
    public Flight()
    {
    	
    }
	public Boolean getOfferEntered() {
		return offerEntered;
	}
	public void setOfferEntered(Boolean offerEntered) {
		this.offerEntered = offerEntered;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSourceCity() {
		return sourceCity;
	}
	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}
	public String getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
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
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getOfferStartDate() {
		return offerStartDate;
	}
	public void setOfferStartDate(String offerStartDate) {
		this.offerStartDate = offerStartDate;
	}
	public String getOfferStartTime() {
		return offerStartTime;
	}
	public void setOfferStartTime(String offerStartTime) {
		this.offerStartTime = offerStartTime;
	}
	public String getOfferEndDate() {
		return offerEndDate;
	}
	public void setOfferEndDate(String offerEndDate) {
		this.offerEndDate = offerEndDate;
	}
	public String getOfferEndTime() {
		return offerEndTime;
	}
	public void setOfferEndTime(String offerEndTime) {
		this.offerEndTime = offerEndTime;
	}
	
}

    
    
    
 
