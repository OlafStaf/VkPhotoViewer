package com.vin.olafstaf.vkphotoviewer.presenter;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Stafiiyevskyi on 14.03.2016.
 */
public class BasePresenter  {

    CompositeSubscription compositeSubscription = new CompositeSubscription();

    public void addSubscription(Subscription subscription) {
        compositeSubscription.add(subscription);
    }

    public void onStop() {
        compositeSubscription.unsubscribe();
    }
}
