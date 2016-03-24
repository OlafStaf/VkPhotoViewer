package com.vin.olafstaf.vkphotoviewer.data.api;

import com.vin.olafstaf.vkphotoviewer.data.api.VKApiInterface;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by Stafiiyevskyi on 14.03.2016.
 */
public class VKApiModule {

    private static VKApiInterface service;
    private static final String BASE_URL = "https://api.vk.com/method/";
    private VKApiModule() {
    }


    public static VKApiInterface getService() {
        if (service == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            service = retrofit.create(VKApiInterface.class);
            return service;
        } else {
            return service;
        }

    }
}
