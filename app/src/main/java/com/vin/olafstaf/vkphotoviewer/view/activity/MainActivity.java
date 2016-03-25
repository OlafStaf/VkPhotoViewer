package com.vin.olafstaf.vkphotoviewer.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.vin.olafstaf.vkphotoviewer.R;
import com.vin.olafstaf.vkphotoviewer.app.util.NetworkUtil;
import com.vin.olafstaf.vkphotoviewer.app.util.PreferencesManager;
import com.vin.olafstaf.vkphotoviewer.view.Navigator;
import com.vin.olafstaf.vkphotoviewer.view.fragment.AlbumsFragment;
import com.vin.olafstaf.vkphotoviewer.view.fragment.BaseFragment;
import com.vin.olafstaf.vkphotoviewer.view.fragment.LoginFragment;
import com.vin.olafstaf.vkphotoviewer.view.fragment.PhotoViewZoomFragment;
import com.vin.olafstaf.vkphotoviewer.view.fragment.PhotosFragment;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements Navigator {

    @Bind(R.id.mainProgress)
    FrameLayout mainProgress;
    BaseFragment firstFragment;

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
                        mainProgress.setVisibility(View.GONE);
                        return;
                    case LoggedIn:
                        navigateToAlbumsScreen();
                        mainProgress.setVisibility(View.GONE);
                        return;
                    case Pending:
                        if (!NetworkUtil.isNetworkConnected(MainActivity.this)){
                            Toast.makeText(MainActivity.this, R.string.no_connection_message, Toast.LENGTH_LONG).show();
                        }
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onError(VKError error) {
                Toast.makeText(MainActivity.this, error.errorMessage, Toast.LENGTH_LONG).show();
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
                navigateToAlbumsScreen();
                mainProgress.setVisibility(View.GONE);
            }

            @Override
            public void onError(VKError error) {
                Toast.makeText(MainActivity.this, R.string.not_access_message, Toast.LENGTH_LONG).show();
                mainProgress.setVisibility(View.GONE);
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void navigateToAlbumsScreen() {
        firstFragment = AlbumsFragment.newInstance();
        replaceFragmentNonBackStack(firstFragment);
    }


    @Override
    public void navigateToSingleAlbumScreen(String albumId, String albumTitle) {
        addFragment(PhotosFragment.newInstance(albumId, albumTitle), albumId);
    }

    @Override
    public void navigateToPhotoViewScreen(String photoUrl) {
        addFragment(PhotoViewZoomFragment.newInstance(photoUrl), photoUrl);
    }

    @Override
    public void navigateToLoginScreen() {
        replaceFragmentNonBackStack(LoginFragment.newInstance());
    }

    private void addFragment(BaseFragment fragment, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_to_left, R.anim.slide_to_right,
                        R.anim.slide_to_right_back, R.anim.slide_to_left_back)
                .add(R.id.fragment_container, fragment, tag)
                .addToBackStack(tag)
                .commit();
    }

    private void replaceFragment(BaseFragment fragment, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_to_left, R.anim.slide_to_right,
                        R.anim.slide_to_right_back, R.anim.slide_to_left_back)
                .replace(R.id.fragment_container, fragment, fragment.getTag())
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

    @Override
    public void navigateBack() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        int i = fragmentManager.getBackStackEntryCount();
        if (i > 1) {
            FragmentManager.BackStackEntry backEntry = fragmentManager
                    .getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 2);
            String str = backEntry.getName();
            BaseFragment currentFragment = (BaseFragment) fragmentManager.findFragmentByTag(str);
            if (currentFragment != null) {
                currentFragment.updateToolbar();
            }
        } else {
            firstFragment.updateToolbar();
        }
    }
}
