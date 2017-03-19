package com.example.gaurav.devslopesradio.activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gaurav.devslopesradio.R;
import com.example.gaurav.devslopesradio.fragments.DetailsFragment;
import com.example.gaurav.devslopesradio.fragments.MainFragment;
import com.example.gaurav.devslopesradio.model.Station;

public class MainActivity extends AppCompatActivity {

    private static MainActivity mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        MainFragment mainFragment = (MainFragment)fm.findFragmentById(R.id.container_main);

        if(mainFragment == null)
        {
            mainFragment = MainFragment.newInstance("blah", "bleh");
            fm.beginTransaction().add(R.id.container_main, mainFragment).commit();
        }

        MainActivity.setMainActivity(this);
    }

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    private static void setMainActivity(MainActivity mainActivity) {
        MainActivity.mainActivity = mainActivity;
    }

    public void loadDetailsScreen(Station selectedStation){

        getSupportFragmentManager().beginTransaction().replace(R.id.container_main, new DetailsFragment()).addToBackStack(null ).commit();

    }
}
