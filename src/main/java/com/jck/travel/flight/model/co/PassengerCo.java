package com.jck.travel.flight.model.co;

import com.jck.travel.flight.util.enumeration.Gender;
import com.jck.travel.flight.util.enumeration.PaxType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashMap;
import java.util.Map;

public class PassengerCo {

    @NotBlank
    @NotNull
    private String title;

    @NotBlank
    @NotNull
    private String firstName;

    private String lastName;

    @NotBlank
    @NotNull
    private String paxType;  // PaxType

    private String dateOfBirth;

    private String gender; // Gender enum

    private String passportNo;

    private String passportExpiry;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String countryCode;

    private String countryName;

    private String contactNo;

    private String email;

    private boolean isLeadPax;

    private String FFAirline;

    private String FFNumber;

    @NotNull
    private FareCo fare;

/*
    private NonLCC_SSRCo nonLccSeat;

    private NonLCC_SSRCo nonLccMeal;

    private SeatCo lccSeat;

    private MealCo lccMeal;
*/

    public @NotBlank @NotNull String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank @NotNull String title) {
        this.title = title;
    }

    public @NotBlank @NotNull String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank @NotNull String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public @NotBlank @NotNull String getPaxType() {
        return paxType;
    }

    public void setPaxType(@NotBlank @NotNull String paxType) {
        this.paxType = paxType;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getPassportExpiry() {
        return passportExpiry;
    }

    public void setPassportExpiry(String passportExpiry) {
        this.passportExpiry = passportExpiry;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isLeadPax() {
        return isLeadPax;
    }

    public void setLeadPax(boolean isLeadPax) {
        this.isLeadPax = isLeadPax;
    }

    public String getFFAirline() {
        return FFAirline;
    }

    public void setFFAirline(String FFAirline) {
        this.FFAirline = FFAirline;
    }

    public String getFFNumber() {
        return FFNumber;
    }

    public void setFFNumber(String FFNumber) {
        this.FFNumber = FFNumber;
    }

    public @NotNull FareCo getFare() {
        return fare;
    }

    public void setFare(@NotNull FareCo fare) {
        this.fare = fare;
    }

    public Map<String, Object> getTboRequest(String isLCC, String isMealRequired, String isSeatPrefRequired) {
        Map<String, Object> params = new LinkedHashMap<>();

        params.put("title", this.title);
        params.put("firstName", this.firstName);
        params.put("lastName", this.lastName);
        params.put("paxType", PaxType.from(this.paxType));
        params.put("dateOfBirth", this.dateOfBirth);
        params.put("gender", Gender.from(this.gender));
        params.put("passportNo", this.passportNo);
        params.put("passportExpiry", this.passportExpiry);
        params.put("addressLine1", this.addressLine1);
        params.put("addressLine2", this.addressLine2);
        params.put("city", this.city);
        params.put("countryCode", this.countryCode);
        params.put("countryName", this.countryName);
        params.put("contactNo", this.contactNo);
        params.put("email", this.email);
        params.put("isLeadPax", this.isLeadPax);
        params.put("FFAirline", this.FFAirline);
        params.put("FFNumber", this.FFNumber);
        params.put("fare", this.fare.getTboRequest());

        /*if (isMealRequired.equals("true")) {
            if (isLCC.equals("true"))
                params.put("Meal", this.lccMeal.getTboRequest());
            else
                params.put("Meal", this.nonLccMeal.getTboRequest());
        }

        if (isSeatPrefRequired.equals("true")) {
            if (isLCC.equals("true"))
                params.put("Seat", this.lccSeat.getTboRequest());
            else
                params.put("Seat", this.nonLccSeat.getTboRequest());
        }
*/
        return params;
    }
}