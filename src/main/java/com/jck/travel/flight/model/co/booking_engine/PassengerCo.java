package com.jck.travel.flight.model.co.booking_engine;

import org.json.JSONObject;

import javax.validation.constraints.NotNull;

public class PassengerCo {

    private String title;

    private boolean isLeadPax;

    private String firstName;

    private String lastName;

    private @NotNull String dateOfBirth;

    private Integer passengerType; //paxType

    private String passportNo;

    private String passportExpiryDate;

    private String country; //MappedByEntityId

    private String nationality;

    private FareCo fare;

    private TicketCo ticket;

    public TicketCo getTicket() {
        return ticket;
    }

    public void setTicket(TicketCo ticket) {
        this.ticket = ticket;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isLeadPax() {
        return isLeadPax;
    }

    public void setLeadPax(boolean isLeadPax) {
        this.isLeadPax = isLeadPax;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public @NotNull String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NotNull String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(Integer passengerType) {
        this.passengerType = passengerType;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getPassportExpiryDate() {
        return passportExpiryDate;
    }

    public void setPassportExpiryDate(String passportExpiryDate) {
        this.passportExpiryDate = passportExpiryDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public FareCo getFare() {
        return fare;
    }

    public void setFare(FareCo fare) {
        this.fare = fare;
    }

    public PassengerCo setRequest(JSONObject response) {

        this.setTitle(response.getString("title"));
        this.setLeadPax(true);
        this.setFirstName(response.getString("firstName"));
        this.setLastName(response.getString("lastName"));
        this.setDateOfBirth(response.getString("dateOfBirth"));
        this.setPassengerType(response.getInt("paxType")); //paxType
        this.setPassportNo(response.getString("passportNo"));

        if (response.has("passportExpiry") && !response.isNull("passportExpiry"))
            this.setPassportExpiryDate(response.getString("passportExpiry"));
        else
            this.setPassportExpiryDate(null);

        //TODO Need to check in Holding
       /*
        "gender": 1,
        "countryName": "India",
        "countryCode": "IN",
        "FFNumber": null,
        "FFAirlineCode": null,
         passenger.setCountry(); //MappedByEntityId
        */
        this.setNationality(response.getString("nationality"));

        if (response.has("fare")) {
            FareCo fareCo = new FareCo();
            fareCo.setRequest(response.getJSONObject("fare"));
            this.setFare(fareCo);
        }

        if (response.has("ticket")) {
            TicketCo ticketCo = new TicketCo();
            ticketCo.setRequest(response.getJSONObject("ticket"));
            this.setTicket(ticketCo);
        }

        return this;
    }
}
