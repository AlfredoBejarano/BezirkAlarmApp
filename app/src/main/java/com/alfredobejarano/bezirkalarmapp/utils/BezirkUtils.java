package com.alfredobejarano.bezirkalarmapp.utils;

import android.content.Context;
import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.android.BezirkMiddleware;

/**
 * Created by jacbe on 11/03/2017.
 */

public class BezirkUtils {
    public static final String zirkName = "Alarm Android App Zirk";

    public Bezirk initializeBezirk(Context context) {
        BezirkMiddleware.initialize(context);
        return BezirkMiddleware.registerZirk(zirkName);
    }
}
