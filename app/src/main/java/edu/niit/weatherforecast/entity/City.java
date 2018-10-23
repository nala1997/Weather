package edu.niit.weatherforecast.entity;

import java.io.Serializable;

public class City implements Serializable {
    private int _id;
    private String province;
    private String city;
    private String number;
    private String allPY;
    private String allfirstPY;
    private String firstPY;

    public City(int _id, String province, String city, String number, String allPY, String allfirstPY, String firstPY) {
        this._id = _id;
        this.province = province;
        this.city = city;
        this.number = number;
        this.allPY = allPY;
        this.allfirstPY = allfirstPY;
        this.firstPY = firstPY;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAllPY() {
        return allPY;
    }

    public void setAllPY(String allPY) {
        this.allPY = allPY;
    }

    public String getAllfirstPY() {
        return allfirstPY;
    }

    public void setAllfirstPY(String allfirstPY) {
        this.allfirstPY = allfirstPY;
    }

    public String getFirstPY() {
        return firstPY;
    }

    public void setFirstPY(String firstPY) {
        this.firstPY = firstPY;
    }

}
