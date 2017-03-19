package com.example.gaurav.devslopesradio.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gaurav.devslopesradio.R;
import com.example.gaurav.devslopesradio.model.Station;

/**
 * Created by Gaurav on 3/7/2017.
 */

public class StationViewHolder extends RecyclerView.ViewHolder{

    private ImageView main_image;
    private TextView main_text;

    public StationViewHolder(View itemView) {
        super(itemView);

        this.main_image = (ImageView) itemView.findViewById(R.id.main_image);
        this.main_text = (TextView) itemView.findViewById(R.id.main_txt);
    }

    public void updateUI(Station station)
    {
        String uri = station.getImg_uri();
        int resource  = main_image.getResources().getIdentifier(uri, null, main_image.getContext().getPackageName());
        main_image.setImageResource(resource);

        main_text.setText(station.getStation_title());

    }
}

