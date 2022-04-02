package com.learn.project.Bootcamp.Project.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import java.math.BigInteger;

@Data
public class UserDto {
    private int id;
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    private String password;
    private boolean isDeleted;
    private boolean isActive;
    private boolean isExpired;
    private boolean isLocked;
    private int invalidAttempCount;
    private String passwordUpdateDate;

    private String gst;
    private BigInteger companyContact;
    private String companyName;


    private String contact;

    public UserDto(){
        this.setDeleted(Boolean.FALSE);
        this.setExpired(false);
        this.setLocked(true);
        this.setInvalidAttempCount(0);
        this.setPasswordUpdateDate("today");
        this.setActive(false);
        this.setDeleted(false);
        this.setPasswordUpdateDate("today");
    }

}
