package com.vin.olafstaf.vkphotoviewer.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.vin.olafstaf.vkphotoviewer.R;
import com.vin.olafstaf.vkphotoviewer.app.util.PreferencesManager;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

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

    }
}
