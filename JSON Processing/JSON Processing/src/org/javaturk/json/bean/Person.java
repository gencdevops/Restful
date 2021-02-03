package org.javaturk.json.bean;

import java.util.Arrays;

public class Person {

    private int id;
    private String name;
    private boolean permanent;
    private Address address;
    private long[] phoneNumbers;
    private String sex;

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

    public boolean isPermanent() {
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long[] getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(long[] phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String role) {
        this.sex = role;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("***** Person Details *****\n");
        sb.append("ID=" + getId() + "\n");
        sb.append("Name=" + getName() + "\n");
        sb.append("Permanent=" + isPermanent() + "\n");
        sb.append("Sex=" + getSex() + "\n");
        sb.append("Phone Numbers=" + Arrays.toString(getPhoneNumbers()) + "\n");
        sb.append("Address=" + getAddress());
        sb.append("\n*****************************");

        return sb.toString();
    }
}
