package com.example.project.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id","longitude", "latitude","road_number", "road_name", "suburb", "postal_code", "house_area", "total_area" })//初始化json排列方法
@JsonInclude(JsonInclude.Include.ALWAYS)//初始化内容为空时json传递null
public class Address {
    private static int total_addresses=0;
    private String id;
    private String latitude;
    private String Longitude;
    private String road_name;
    private String suburb;
    private String postal_code;
    private String road_number;
    private double house_area;
    private double total_area;
    public Address(String latitude, String longitude, String road_number,String road_name, String suburb, String postal_code, double house_area, double total_area) {
        this.id="ad"+(total_addresses+1);
        this.latitude = latitude;
        this.Longitude = longitude;
        this.road_number=road_number;
        this.road_name = road_name;
        this.suburb = suburb;
        this.postal_code = postal_code;
        this.house_area = house_area;
        this.total_area = total_area;
        total_addresses++;
    }
    public static void doNothing(){
        System.out.println("do nothings");
    }
    public Address(String id, String latitude, String longitude, String road_number,String road_name, String suburb, String postal_code, double house_area, double total_area) {
        this.id=id;
        this.latitude = latitude;
        this.Longitude = longitude;
        this.road_number=road_number;
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

    @Override
    public String toString() {
        return id+","+latitude+","+road_number+","+road_name+","+suburb+","+postal_code+","+house_area+","+total_area;
    }

    public String getId() {
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

    public String getRoad_number(){
        return road_number;
    }


}
