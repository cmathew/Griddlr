package com.example.cmathew.griddlr.welcome;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cmathew.griddlr.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class WelcomeSlideFragment extends Fragment {
    private int drawableResourceId;
    private int captionResourceId;
    private int headerResourceId;

    @BindView(R.id.welcome_slide_image)
    ImageView imgView;
    @BindView(R.id.welcome_header_text)
    TextView headerView;
    @BindView(R.id.welcome_slide_text) TextView captionView;

    private Unbinder unbinder;

    public WelcomeSlideFragment() {
        // Required empty public constructor
    }

    public static WelcomeSlideFragment newInstance(Slide slide) {
        WelcomeSlideFragment fragment = new WelcomeSlideFragment();

        Bundle args = WelcomeSlideFragment.BuildArgumentBundle(slide);
        fragment.setArguments(args);

        return fragment;
    }

    private static Bundle BuildArgumentBundle(Slide slide) {
        Bundle args = new Bundle();

        args.putInt("drawable_resource_id", slide.getDrawableResourceId());
        args.putInt("header_resource_id", slide.getHeaderResourceId());
        args.putInt("caption_resource_id", slide.getCaptioneResourceId());

        return args;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome_slide_page, container, false);

        unbinder = ButterKnife.bind(this, view);

        imgView.setImageResource(drawableResourceId);
        headerView.setText(headerResourceId);
        captionView.setText(captionResourceId);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
