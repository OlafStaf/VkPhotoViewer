package com.vin.olafstaf.vkphotoviewer.app;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.vin.olafstaf.vkphotoviewer.app.util.PreferencesManager;
import com.vk.sdk.VKSdk;

import io.fabric.sdk.android.Fabric;

/**
 * Created by Stafiiyevskyi on 23.03.2016.
 */
public class VKPVApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        VKSdk.initialize(getApplicationContext());
        PreferencesManager.initializeInstance(getApplicationContext());
    }
}
