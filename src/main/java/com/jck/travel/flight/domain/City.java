package com.jck.travel.flight.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "City_Master")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cityCode")
    private String cityCode;

    @Column(name = "cityName")
    private String cityName;

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
    private Country country;

    public Long getId() {
        return id;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
