package com.example.gaurav.devslopesradio.model;

/**
 * Created by Gaurav on 3/13/2017.
 */

public class Station {
    final String DRAWABLE = "drawable/";
    private String station_title;
    private String img_uri;

    public Station(String station_title, String img_uri) {
        this.station_title = station_title;
        this.img_uri = img_uri;
    }


    public String getStation_title() {
        return station_title;
    }


    public String getImg_uri()
    {

        return DRAWABLE + img_uri;
    }


}
