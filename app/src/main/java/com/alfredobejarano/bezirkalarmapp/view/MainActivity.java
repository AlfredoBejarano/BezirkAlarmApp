package com.alfredobejarano.bezirkalarmapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alfredobejarano.bezirkalarmapp.R;
import com.alfredobejarano.bezirkalarmapp.utils.BezirkUtils;
import com.bezirk.middleware.Bezirk;

public class MainActivity extends AppCompatActivity {

    private Bezirk bezirk;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        bezirk = new BezirkUtils().initializeBezirk(this);
    }
}
