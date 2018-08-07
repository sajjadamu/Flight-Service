package com.jck.travel.flight.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Airport_Master")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "airportCode")
    private String airportCode;

    @Column(name = "airportName")
    private String airportName;


    @Column(name = "createdBy")
    private Integer createdBy;

    @Column(name = "deletedBy")
    private Integer deletedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateCreated", updatable = false, nullable = false)
    @org.hibernate.annotations.CreationTimestamp
    private Date dateCreated;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastModified", updatable = false, nullable = false)
    @org.hibernate.annotations.CreationTimestamp
    private Date lastModified;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateDeleted")
    @org.hibernate.annotations.UpdateTimestamp
    private Date dateDeleted;

    @Column(name = "isActive")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(nullable = false)
    private City city;

    public Long getId() {
        return id;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Integer deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Date getDateDeleted() {
        return dateDeleted;
    }

    public void setDateDeleted(Date dateDeleted) {
        this.dateDeleted = dateDeleted;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", airportCode='" + airportCode + '\'' +
                ", airportName='" + airportName + '\'' +
                ", createdBy=" + createdBy +
                ", deletedBy=" + deletedBy +
                ", dateCreated=" + dateCreated +
                ", lastModified=" + lastModified +
                ", dateDeleted=" + dateDeleted +
                ", isActive=" + isActive +
                ", city=" + city +
                '}';
    }

    @Override
    public int hashCode() {
        return airportCode.hashCode();
    }
}
