package com.alfredobejarano.bezirkalarmapp.events;

import com.bezirk.middleware.messages.Event;

/**
 * Created by jacbe on 11/03/2017.
 */

public class StatusEvent extends Event {
    private final String userId;

    public StatusEvent(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
