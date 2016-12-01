package com.nishinonaru.devinfo.display.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nishinonaru.devinfo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.mainFrgmContainer, MainFragment.newInstance(), null).commit();


    }
}
