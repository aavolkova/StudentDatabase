package me.anna.demo.models;

import com.sun.istack.internal.Nullable;
import com.sun.org.glassfish.gmbal.NameValue;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=1, max=50, message = "Must enter your first name.")
    @NameValue
    private String firstName;

    @NotEmpty
    @Size(min=1, max=50, message = "Must enter your last name.")
    @NameValue
    private String lastName;

    @NotEmpty
    @Size(min=1, max=50, message = "Must enter your email address.")
    @Email
    private String emailAddress;

    // Null values are allowed for Phone number:
    @Nullable
    @Min(1000000000)
    @Max(9999999999L)
    private long phoneNumber;


    // Null values are allowed for School:
    @Nullable
//    @Size(min=1, max=50, message = "Must enter your School name.")
    private String school;


    // Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
