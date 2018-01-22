package com.example.cmathew.griddlr.matchmaker;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cmathew.griddlr.R;
import com.example.cmathew.griddlr.databinding.FragmentMatchMakerBinding;
import com.example.cmathew.griddlr.databinding.FragmentWelcomeSlidePageBinding;
import com.example.cmathew.griddlr.models.Recipe;
import com.example.cmathew.griddlr.remote.MatchClient;
import com.example.cmathew.griddlr.remote.RecipeClient;
import com.example.cmathew.griddlr.remote.RestClient;
import com.example.cmathew.griddlr.welcome.WelcomeSlideViewModel;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;

public class MatchMakerFragment extends Fragment {
    @BindView(R.id.next_recipe_button)
    Button nextRecipeButton;

    @Inject
    RestClient restClient;

    private MatchClient matchClient;
    private RecipeClient recipeClient;

    private RecipeViewModel recipeViewModel;
    private FragmentMatchMakerBinding binding;
    private Unbinder unbinder;

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
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);

        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.matchClient = new MatchClient(restClient);
        this.recipeClient = new RecipeClient(restClient);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_match_maker, container, false);
        this.unbinder = ButterKnife.bind(this, view);

        this.binding = FragmentMatchMakerBinding.bind(view);
        this.recipeViewModel = new RecipeViewModel(getActivity());

        nextRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long[] recs = matchClient.getRecommendations(1);
                Recipe nextRecipe = recipeClient.getRecipe(recs[0]);
                recipeViewModel.setCurrentRecipe(nextRecipe);

                if (binding.getRecipe() == null) {
                    binding.setRecipe(recipeViewModel);
                }
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        unbinder.unbind();;
    }
}
