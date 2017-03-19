package com.example.gaurav.devslopesradio.fragments;


import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gaurav.devslopesradio.R;
import com.example.gaurav.devslopesradio.adapters.StationsAdapter;
import com.example.gaurav.devslopesradio.services.DataService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StationsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_STATION_TYPE = "station_type";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public static final int STATION_TYPE_FEATURED = 0;
    public static final int STATION_TYPE_RECENT = 1;
    public static final int STATION_TYPE_PARTY = 2;

    private int station_type;

    public StationsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param station_type The radio stations type.

     * @return A new instance of fragment StationsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StationsFragment newInstance(int station_type) {
        StationsFragment fragment = new StationsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_STATION_TYPE, station_type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            station_type = getArguments().getInt(ARG_STATION_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_stations, container, false);
        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.recycler_stations);
        recyclerView.setHasFixedSize(true);

        StationsAdapter adapter;
        if (station_type == STATION_TYPE_FEATURED)
        {
            adapter = new StationsAdapter(DataService.getInstance().getFeaturedStations());
        }
        else if (station_type == STATION_TYPE_RECENT)
        {
            adapter = new StationsAdapter(DataService.getInstance().getRecentStations());
        }
        else
        {
            adapter = new StationsAdapter(DataService.getInstance().getPartyStations());
        }

        recyclerView.addItemDecoration(new HorizontalSpaceItemDecorator(30));
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);



        return v;
    }

}

class HorizontalSpaceItemDecorator extends RecyclerView.ItemDecoration
{
    private final int spacer;

    public HorizontalSpaceItemDecorator(int spacer) {
        this.spacer = spacer;

    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.right=spacer;
    }
}
