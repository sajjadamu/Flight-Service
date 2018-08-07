package com.jck.travel.flight.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Country_Master")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "countryCode")
    private String countryCode;

    @Column(name = "countryName")
    private String countryName;

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

    public Long getId() {
        return id;
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
}
