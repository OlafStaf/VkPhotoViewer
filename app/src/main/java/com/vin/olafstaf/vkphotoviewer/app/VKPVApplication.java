package com.vin.olafstaf.vkphotoviewer.app;

import android.app.Application;

import com.vin.olafstaf.vkphotoviewer.app.util.PreferencesManager;
import com.vk.sdk.VKSdk;

/**
 * Created by Stafiiyevskyi on 23.03.2016.
 */
public class VKPVApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(getApplicationContext());
        PreferencesManager.initializeInstance(getApplicationContext());
    }
}
