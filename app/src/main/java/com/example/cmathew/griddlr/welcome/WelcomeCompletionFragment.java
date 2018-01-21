package com.example.cmathew.griddlr.welcome;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cmathew.griddlr.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;

public class WelcomeCompletionFragment extends Fragment {
    @BindView(R.id.complete_welcome_button)
    Button completionButton;

    @Inject
    SharedPreferences prefs;

    private Unbinder unbinder;

    public WelcomeCompletionFragment() {
        // Required empty public constructor
    }

    public static WelcomeCompletionFragment newInstance() {
        WelcomeCompletionFragment fragment = new WelcomeCompletionFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);

        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome_completion, container, false);

        this.unbinder = ButterKnife.bind(this, view);

        completionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefs.edit().putBoolean(WelcomeActivity.PREFS_KEY_WELCOME_COMPLETE, true).apply();
                ((WelcomeActivity) getActivity()).onUserWelcomed();
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        unbinder.unbind();
    }
}
