package com.example.cmathew.griddlr.welcome;


import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cmathew.griddlr.R;
import com.example.cmathew.griddlr.databinding.FragmentWelcomeSlidePageBinding;

public class WelcomeSlideFragment extends Fragment {
    private static final String ARG_SLIDE = "welcome_slide";

    /*
    @BindView(R.id.welcome_slide_image)
    ImageView imgView;
    @BindView(R.id.welcome_slide_header)
    TextView headerView;
    @BindView(R.id.welcome_slide_message)
    TextView messageView;
    */

    private WelcomeSlide slide;

    private WelcomeSlideViewModel slideViewModel;

    public WelcomeSlideFragment() {
        // Required empty public constructor
    }

    public static WelcomeSlideFragment newInstance(WelcomeSlide slide) {
        WelcomeSlideFragment fragment = new WelcomeSlideFragment();

        Bundle args = WelcomeSlideFragment.BuildArgumentBundle(slide);
        fragment.setArguments(args);

        return fragment;
    }

    private static Bundle BuildArgumentBundle(WelcomeSlide slide) {
        Bundle args = new Bundle();
        args.putParcelable(ARG_SLIDE, slide);
        return args;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            this.slide = getArguments().getParcelable(ARG_SLIDE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome_slide_page, container, false);

        FragmentWelcomeSlidePageBinding binding = FragmentWelcomeSlidePageBinding.bind(view);
        this.slideViewModel = new WelcomeSlideViewModel(slide);
        binding.setSlide(slideViewModel);

        /*
        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        User user = new User("Test", "User");
        binding.setUser(user);
        */

        /*
        unbinder = ButterKnife.bind(this, view);
        imgView.setImageResource(drawableResourceId);
        headerView.setText(headerResourceId);
        messageView.setText(captionResourceId);
        */

        return view;
    }
}
