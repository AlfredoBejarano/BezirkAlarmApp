package com.alfredobejarano.bezirkalarmapp.listeners;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.alfredobejarano.bezirkalarmapp.R;
import com.alfredobejarano.bezirkalarmapp.events.StatusEvent;
import com.bezirk.middleware.Bezirk;

/**
 * Created by jacbe on 11/03/2017.
 */

public class StatusButtonListener implements View.OnClickListener {
    private Bezirk bezirk;
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setBezirk(Bezirk bezirk) {
        this.bezirk = bezirk;
    }

    @Override
    public void onClick(View v) {
        bezirk.sendEvent(new StatusEvent(Build.MANUFACTURER + " " + Build.MODEL));
        v.setBackground(context.getResources().getDrawable(R.drawable.ok_button_background));
        ((ImageButton) v).setImageResource(R.drawable.ic_safe);
    }
}
