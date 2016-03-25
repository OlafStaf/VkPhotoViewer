package com.vin.olafstaf.vkphotoviewer.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.vin.olafstaf.vkphotoviewer.R;

import butterknife.Bind;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;

/**
 * Created by Stafiiyevskyi on 24.03.2016.
 */
public class PhotoViewZoomFragment extends BaseFragment {

    private static final String IMAGE_URL_BUNDLE = "image_url_bundle";

    @Bind(R.id.image)
    ImageViewTouch ivPhoto;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;

    private String imageUrl;
    public static BaseFragment newInstance(String imageUrl) {
        Bundle args = new Bundle();
        args.putString(IMAGE_URL_BUNDLE, imageUrl);
        PhotoViewZoomFragment fragment = new PhotoViewZoomFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageUrl = getArguments().getString(IMAGE_URL_BUNDLE);
        Glide.with(getActivity())
                .load(imageUrl)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(ivPhoto);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_photo_view;
    }

    @Override
    public void updateToolbar() {

    }
}
