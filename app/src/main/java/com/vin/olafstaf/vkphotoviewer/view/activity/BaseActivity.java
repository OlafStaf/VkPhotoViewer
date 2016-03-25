package com.vin.olafstaf.vkphotoviewer.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.vin.olafstaf.vkphotoviewer.R;
import com.vin.olafstaf.vkphotoviewer.view.BaseNavigator;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Stafiiyevskyi on 23.03.2016.
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseNavigator {
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewID());
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onBackPressed() {
        navigateBack();
        super.onBackPressed();

    }

    public abstract int getContentViewID();
}
