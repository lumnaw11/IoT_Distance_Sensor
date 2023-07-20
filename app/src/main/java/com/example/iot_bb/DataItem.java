package com.example.iot_bb;

public class DataItem {
    private String team_id;
    private double data1;
    private double data2;
    private double data3;
    private String create_time;


    // Constructor
    public DataItem(String team_id, double data1, double data2, double data3, String create_time) {
        this.team_id = team_id;
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.create_time = create_time;
    }

    public double getData1() {
        return data1;
    }

    public String getCreate_time() {
        return create_time;
    }

}
