package com.vin.olafstaf.vkphotoviewer.app.util;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by Stafiiyevskyi on 25.03.2016.
 */
public class NetworkUtil {
    public NetworkUtil() {
    }

    public static boolean isNetworkConnected(Context mContext) {
        if (mContext != null) {
            ConnectivityManager manager = (ConnectivityManager) mContext
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            if (manager.getActiveNetworkInfo() != null) {
                return (manager.getActiveNetworkInfo().isAvailable() && manager
                        .getActiveNetworkInfo().isConnected());
            }
        }
        return false;
    }
}
