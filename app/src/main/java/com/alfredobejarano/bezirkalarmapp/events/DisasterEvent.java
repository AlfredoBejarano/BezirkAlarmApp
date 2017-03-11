package com.alfredobejarano.bezirkalarmapp.events;

import com.bezirk.middleware.messages.Event;

/**
 * Created by jacbe on 11/03/2017.
 */

public class DisasterEvent extends Event {
    private final boolean disaster;

    public DisasterEvent(boolean disaster) {
        this.disaster = disaster;
    }

    public boolean isDisaster() {
        return disaster;
    }
}
