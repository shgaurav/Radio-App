package com.example.gaurav.devslopesradio.activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gaurav.devslopesradio.R;
import com.example.gaurav.devslopesradio.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

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
    }
}
