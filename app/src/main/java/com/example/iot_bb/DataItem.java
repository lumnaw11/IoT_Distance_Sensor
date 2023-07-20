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

    public String getTeam_id() {
        return team_id;
    }

    public double getData1() {
        return data1;
    }

    public double getData2() {
        return data2;
    }

    public double getData3() {
        return data3;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public void setData1(double data1) {
        this.data1 = data1;
    }

    public void setData2(double data2) {
        this.data2 = data2;
    }

    public void setData3(double data3) {
        this.data3 = data3;
    }


}
