package com.alfredobejarano.bezirkalarmapp.view;

import android.app.NotificationManager;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;

import com.alfredobejarano.bezirkalarmapp.R;
import com.alfredobejarano.bezirkalarmapp.events.DisasterEvent;
import com.alfredobejarano.bezirkalarmapp.listeners.DisasterEventReceiver;
import com.alfredobejarano.bezirkalarmapp.listeners.StatusButtonListener;
import com.alfredobejarano.bezirkalarmapp.utils.BezirkUtils;
import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.messages.EventSet;

public class MainActivity extends AppCompatActivity {
    private Bezirk bezirk;
    private ImageButton statusImageButton;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        bezirk = new BezirkUtils().initializeBezirk(this);
        listenToDisasters();
        setupImageButton();
    }

    private void listenToDisasters() {
        final EventSet eventSet = new EventSet(DisasterEvent.class);

        DisasterEventReceiver disasterEventReceiver = new DisasterEventReceiver();
        disasterEventReceiver.setContext(this);

        eventSet.setEventReceiver(disasterEventReceiver);
        bezirk.subscribe(eventSet);
    }

    private void setupImageButton() {
        statusImageButton = (ImageButton) findViewById(R.id.user_status_button);

        StatusButtonListener statusButtonListener = new StatusButtonListener();
        statusButtonListener.setBezirk(bezirk);
        statusButtonListener.setContext(this);

        statusImageButton.setOnClickListener(statusButtonListener);
    }
}
