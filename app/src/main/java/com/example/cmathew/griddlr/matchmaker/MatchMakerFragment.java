package com.example.cmathew.griddlr.matchmaker;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cmathew.griddlr.R;

public class MatchMakerFragment extends Fragment {
    public MatchMakerFragment() {
        // Required empty public constructor
    }

    public static MatchMakerFragment newInstance() {
        MatchMakerFragment fragment = new MatchMakerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_match_maker, container, false);
    }

}
