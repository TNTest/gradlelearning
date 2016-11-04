package com.udacity.gradle.jokescreen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class JokeScreenFragment extends Fragment {


    public JokeScreenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_joke_screen, container, false);
        TextView tv = (TextView) root.findViewById(R.id.screen_text);
        tv.setText(getActivity().getIntent().getStringExtra(JokeScreenActivity.JTXT));
        return root;
    }

}
