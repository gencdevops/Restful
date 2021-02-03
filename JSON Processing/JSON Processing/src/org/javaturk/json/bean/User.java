package org.javaturk.json.bean;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private String email;
    private Date dateOfBirth;
    public String creditCardNumber;

    public static int counter = 0;
    private transient boolean isMember = false;

    public User() {
        counter++;
    }

    public User(int id, String name, String email, Date dateOfBirth, String creditCardNumber,
            boolean isMember) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.creditCardNumber = creditCardNumber;
        this.isMember = isMember;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public boolean isMember() {
        return isMember;
    }

    public void setMember(boolean isMember) {
        this.isMember = isMember;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + ", dateOfBirth="
                + dateOfBirth + ", creditCardNumber=" + creditCardNumber + ", isMember=" + isMember
                + "]";
    }
}
