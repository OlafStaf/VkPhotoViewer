package com.vin.olafstaf.vkphotoviewer.view.fragment;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;

import com.vin.olafstaf.vkphotoviewer.R;
import com.vin.olafstaf.vkphotoviewer.view.activity.BaseActivity;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;

import butterknife.OnClick;


/**
 * Created by Stafiiyevskyi on 23.03.2016.
 */
public class LoginFragment extends BaseFragment {

    private static final String[] scope = new String[]{
            VKScope.PHOTOS
    };

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @OnClick(R.id.btn_authorization)
    void onLoginClick() {
        VKSdk.login(getActivity(), scope);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_authorization;
    }

    @Override
    public void updateToolbar() {
        ActionBar actionBar = ((BaseActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setSubtitle(getString(R.string.autorization_page_title));
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
    }
}
