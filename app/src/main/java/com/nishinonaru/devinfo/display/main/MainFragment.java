package com.nishinonaru.devinfo.display.main;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nishinonaru.devinfo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private static final String TAG = "MainFragment";
    private RecyclerView mRecyclerView;
    private MainRvAdapter mMainRvAdapter;


    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        initView(v);


        return v;
    }

    private void initView(View v) {
        mMainRvAdapter = new MainRvAdapter(this.getActivity());
        mRecyclerView = (RecyclerView) v.findViewById(R.id.rvContent);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mRecyclerView.setAdapter(mMainRvAdapter);
    }


    class MainRvAdapter extends RecyclerView.Adapter<MainRvAdapter.MainViewHolder> {

        private Context mContext;

        public MainRvAdapter(Context context) {
            mContext = context;
        }

        @Override
        public MainRvAdapter.MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(MainRvAdapter.MainViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        class MainViewHolder extends RecyclerView.ViewHolder {

            TextView tvTitle;
            ImageView ivHead;

            public MainViewHolder(View itemView) {
                super(itemView);
                //tvTitle = itemView.findViewById(R.id.)


            }
        }
    }
}
