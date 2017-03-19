package com.example.gaurav.devslopesradio.services;

import com.example.gaurav.devslopesradio.model.Station;

import java.util.ArrayList;

/**
 * Created by Gaurav on 3/13/2017.
 */

public class DataService {
    private static final DataService ourInstance = new DataService();

    public static DataService getInstance() {
        return ourInstance;
    }

    private DataService() {
    }

    public ArrayList<Station> getFeaturedStations(){
        //downloading featured  stations from the internet.
        ArrayList<Station> list  = new ArrayList<>();
        list.add(new Station("Flight Plan(Tunes for travel)", "flightplanmusic"));
        list.add(new Station("Two Wheelin(Biking Playlist)", "bicyclemusic"));
        list.add(new Station("Kids Jam (Music for Children)", "kidsmusic"));

        return list;
    }

    public ArrayList<Station> getRecentStations(){
        //downloading featured  stations from the internet.
        ArrayList<Station> list  = new ArrayList<>();
        list.add(new Station("Flight Plan(Tunes for travel)", "vinylmusic"));
        list.add(new Station("Two Wheelin(Biking Playlist)", "socialmusic"));
        list.add(new Station("Kids Jam (Music for Children)", "keymusic"));
        return list;
    }

    public ArrayList<Station> getPartyStations(){
        //downloading featured  stations from the internet.
        ArrayList<Station> list  = new ArrayList<>();
        list.add(new Station("Flight Plan(Tunes for travel)", "flightplanmusic"));
        list.add(new Station("Two Wheelin(Biking Playlist)", "bicyclemusic"));
        list.add(new Station("Kids Jam (Music for Children)", "kidsmusic"));
        return list;
    }
}
