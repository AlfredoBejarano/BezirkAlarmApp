package com.alfredobejarano.bezirkalarmapp.utils;

import android.app.Activity;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.android.BezirkMiddleware;

/**
 * Created by jacbe on 11/03/2017.
 */

public class BezirkUtils {
    public static final String zirkName = "Alarm Android App Zirk";

    public Bezirk initializeBezirk(Activity activity) {
        BezirkMiddleware.initialize(activity);
        return BezirkMiddleware.registerZirk(zirkName);
    }
}
