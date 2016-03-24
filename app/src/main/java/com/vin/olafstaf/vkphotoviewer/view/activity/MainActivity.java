package com.vin.olafstaf.vkphotoviewer.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.vin.olafstaf.vkphotoviewer.R;
import com.vin.olafstaf.vkphotoviewer.view.Navigator;
import com.vin.olafstaf.vkphotoviewer.view.fragment.AlbumsFragment;
import com.vin.olafstaf.vkphotoviewer.view.fragment.BaseFragment;
import com.vin.olafstaf.vkphotoviewer.view.fragment.LoginFragment;
import com.vin.olafstaf.vkphotoviewer.view.fragment.PhotoViewZoomFragment;
import com.vin.olafstaf.vkphotoviewer.view.fragment.PhotosFragment;
import com.vin.olafstaf.vkphotoviewer.app.util.PreferencesManager;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

public class MainActivity extends BaseActivity implements Navigator {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle(R.string.app_name);
        VKSdk.wakeUpSession(this, new VKCallback<VKSdk.LoginState>() {
            @Override
            public void onResult(VKSdk.LoginState res) {
                switch (res) {
                    case LoggedOut:
                        navigateToLoginScreen();
                        break;
                    case LoggedIn:
                        navigateToAlbumsScreen();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onError(VKError error) {

            }
        });
    }

    @Override
    public int getContentViewID() {
        return R.layout.activity_main;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                PreferencesManager.getInstance().setAccessToken(res.accessToken);
                PreferencesManager.getInstance().setUserId(res.userId);
                navigateToAlbumsScreenNonBackStack();
            }

            @Override
            public void onError(VKError error) {
                Toast.makeText(MainActivity.this, R.string.not_access_message, Toast.LENGTH_LONG).show();
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void navigateToAlbumsScreen() {
        replaceFragmentNonBackStack(AlbumsFragment.newInstance());
    }

    @Override
    public void navigateToAlbumsScreenNonBackStack() {
        replaceFragmentNonBackStack(AlbumsFragment.newInstance());
    }

    @Override
    public void navigateToSingleAlbumScreen(String albumId) {
        replaceFragment(PhotosFragment.newInstance(albumId));
    }

    @Override
    public void navigateToPhotoViewScreen(String photoUrl) {
        addFragment(PhotoViewZoomFragment.newInstance(photoUrl));
    }

    @Override
    public void navigateToLoginScreen() {
        replaceFragmentNonBackStack(LoginFragment.newInstance());
    }

    private void addFragment(BaseFragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_to_left, R.anim.slide_to_right,
                        R.anim.slide_to_right_back, R.anim.slide_to_left_back)
                .add(R.id.fragment_container, fragment, fragment.getTag())
                .addToBackStack(fragment.getTag())
                .commit();
    }

    private void replaceFragmentNonBackStack(BaseFragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_to_left, R.anim.slide_to_right,
                        R.anim.slide_to_right_back, R.anim.slide_to_left_back)
                .replace(R.id.fragment_container, fragment, fragment.getTag())
                .commit();
    }

    private void replaceFragment(BaseFragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_to_left, R.anim.slide_to_right,
                        R.anim.slide_to_right_back, R.anim.slide_to_left_back)
                .replace(R.id.fragment_container, fragment, fragment.getTag())
                .addToBackStack(fragment.getTag())
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
