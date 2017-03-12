package com.alfredobejarano.bezirkalarmapp.listeners;

import android.app.NotificationManager;
import android.content.Context;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;

import com.alfredobejarano.bezirkalarmapp.R;
import com.alfredobejarano.bezirkalarmapp.events.DisasterEvent;
import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.bezirk.middleware.messages.Event;
import com.bezirk.middleware.messages.EventSet;

/**
 * Created by jacbe on 11/03/2017.
 */

public class DisasterEventReceiver implements EventSet.EventReceiver {
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void receiveEvent(Event event, ZirkEndPoint zirkEndPoint) {
        if (event instanceof DisasterEvent) {
            buildNotification();
        }
    }

    private void buildNotification() {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_warning)
                .setContentTitle(context.getString(R.string.notification_title))
                .setContentText(context.getString(R.string.notification_body))
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));

        NotificationManager mng = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        mng.notify(001, mBuilder.build());
    }
}
