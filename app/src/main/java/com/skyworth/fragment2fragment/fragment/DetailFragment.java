package com.skyworth.fragment2fragment.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skyworth.fragment2fragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private TextView mTextView;
    private Bundle args;

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(String type) {
        Bundle args = new Bundle();
        args.putString("type", type);
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        args = getArguments();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        mTextView = (TextView) rootView.findViewById(R.id.text_view);
        mTextView.setText(args.get("position").toString());
        return rootView;
    }

}
