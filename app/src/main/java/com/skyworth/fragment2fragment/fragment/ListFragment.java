package com.skyworth.fragment2fragment.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.skyworth.fragment2fragment.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView mListView;
    private ListAdapter mAdapter;
    private List<String> mData;

    public ListFragment() {
        // Required empty public constructor
    }

    public static ListFragment newInstance(String type) {
        Bundle args = new Bundle();
        args.putString("type", type);
        ListFragment fragment = new ListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mData == null) {
            mData = new ArrayList<>();
        }
        loadData();
    }

    private void loadData() {
        for (int i = 0; i < 10; i++) {
            mData.add("Item" + i);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        mListView = (ListView) rootView.findViewById(R.id.list_view);

        mAdapter = new ListAdapter(getActivity(), mData);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mOnListItemSelectedListener = (OnListItemSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnListItemSelectedListener");
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mOnListItemSelectedListener.onListItemSelected(position);
    }

    private OnListItemSelectedListener mOnListItemSelectedListener;

    public interface OnListItemSelectedListener {
        void onListItemSelected(int position);
    }


    /* ================适配器相关===============*/
    public class ListAdapter extends BaseAdapter {

        private List<String> mData;
        private Context mContext;

        public ListAdapter(Context context, List<String> data) {
            this.mContext = context;
            this.mData = data;
        }

        @Override
        public int getCount() {
            return mData.size() == 0 ? 0 : mData.size();
        }

        @Override
        public Object getItem(int position) {
            return mData == null ? null : mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list, parent, false);
                holder.mTextView = (TextView) convertView.findViewById(R.id.text_view);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            String text = mData.get(position);
            if (text != null && !"".equals(text)) {
                holder.mTextView.setText(text);
            }
            return convertView;
        }

        public class ViewHolder {
            TextView mTextView;
        }
    }

}
