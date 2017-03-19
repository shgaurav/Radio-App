package com.example.gaurav.devslopesradio.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gaurav.devslopesradio.R;
import com.example.gaurav.devslopesradio.activities.MainActivity;
import com.example.gaurav.devslopesradio.holders.StationViewHolder;
import com.example.gaurav.devslopesradio.model.Station;

import java.util.ArrayList;

/**
 * Created by Gaurav on 3/7/2017.
 */

public class StationsAdapter extends RecyclerView.Adapter<StationViewHolder> {

    private ArrayList<Station> stations;

    public StationsAdapter(ArrayList<Station> stations) {
        this.stations = stations;
    }

    @Override
    public void onBindViewHolder(StationViewHolder holder, final int position) {

        final Station station = stations.get(position);
        holder.updateUI(station);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Load the details
                MainActivity.getMainActivity().loadDetailsScreen(station);


            }
        });

    }

    @Override
    public int getItemCount() {
        return stations.size();
    }

    @Override
    public StationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View stationCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_station,parent, false);
        return new StationViewHolder(stationCard);
    }
}
