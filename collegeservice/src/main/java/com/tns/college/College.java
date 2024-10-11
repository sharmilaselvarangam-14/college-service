package com.tns.college;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class College {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="collegeid")
    private Integer collegetId;
	@Column(name="companyname")
    private String companyName;
	@Column(name="position")
    private String position;
	@Column(name="location")
    private String location;

    public College() {
        super();
    }

    public College(Integer collegeId, String companyName, String position, String location) {
        super();
        this.collegetId = collegeId;
        this.companyName = companyName;
        this.position = position;
        this.location = location;
    }

   
    public Integer getCollegeId() {
        return collegetId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegetId = collegeId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "College[College ID: " + collegetId + ", Company Name: " + companyName + ", Position: " + position + ", Location: " + location + "]";
    }
}
