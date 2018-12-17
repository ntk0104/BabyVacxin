package com.dmt.sannguyen.lgwfb;

public class TramXa {
    private int IDTramXa;
    private String DiaChi;
    private String Street;
    private String Ward;
    private String District;
    private String City;
    private float Xvalue;
    private float Yvalue;

    public TramXa(int IDTramXa, String diaChi, String street, String ward, String district, String city, float xvalue, float yvalue) {
        this.IDTramXa = IDTramXa;
        DiaChi = diaChi;
        Street = street;
        Ward = ward;
        District = district;
        City = city;
        Xvalue = xvalue;
        Yvalue = yvalue;
    }

    public int getIDTramXa() {
        return IDTramXa;
    }

    public void setIDTramXa(int IDTramXa) {
        this.IDTramXa = IDTramXa;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getWard() {
        return Ward;
    }

    public void setWard(String ward) {
        Ward = ward;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public float getXvalue() {
        return Xvalue;
    }

    public void setXvalue(float xvalue) {
        Xvalue = xvalue;
    }

    public float getYvalue() {
        return Yvalue;
    }

    public void setYvalue(float yvalue) {
        Yvalue = yvalue;
    }
}
