package com.example.project;

public class Address {
    private static int total_addresses=0;
    private int id;
    private String latitude;
    private String Longitude;
    private String road_name;
    private String suburb;
    private String postal_code;
    private String road_number;
    private double house_area;
    private double total_area;
    public Address(String latitude, String longitude, String road_number,String road_name, String suburb, String postal_code, double house_area, double total_area) {
        this.id=total_addresses+1;
        this.latitude = latitude;
        this.Longitude = longitude;
        this.road_name = road_name;
        this.suburb = suburb;
        this.postal_code = postal_code;
        this.house_area = house_area;
        this.total_area = total_area;
        total_addresses++;
    }

    public static int getTotal_addresses() {
        return total_addresses;
    }

    public int getId() {
        return id;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public String getRoad_name() {
        return road_name;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public double getHouse_area() {
        return house_area;
    }

    public double getTotal_area() {
        return total_area;
    }


}
