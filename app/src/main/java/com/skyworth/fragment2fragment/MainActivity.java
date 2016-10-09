package com.skyworth.fragment2fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.skyworth.fragment2fragment.fragment.DetailFragment;
import com.skyworth.fragment2fragment.fragment.ListFragment;
import com.skyworth.fragment2fragment.utils.ActivityUtil;

public class MainActivity extends AppCompatActivity
        implements ListFragment.OnListItemSelectedListener {

    private static final String TAG = "MainActivity";

    private ListFragment mListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListFragment = ListFragment.newInstance("ListFragment");
        ActivityUtil.addFragmentToActivity(getSupportFragmentManager(),
                mListFragment, R.id.frame_container);
    }

    @Override
    public void onListItemSelected(int position) {
        Log.d(TAG, position + "");
        Bundle args = new Bundle();
        args.putInt("position",position);
        DetailFragment fragment = DetailFragment.newInstance("DetailFragment");
        fragment.setArguments(args);
        ActivityUtil.addFragmentToActivity(getSupportFragmentManager(), fragment, R.id.frame_container);
    }
}
