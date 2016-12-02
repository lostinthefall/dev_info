package com.nishinonaru.devinfo.display.main;


import android.content.Context;
import android.content.Intent;
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
import com.nishinonaru.devinfo.data.entity.ShowItem;
import com.nishinonaru.devinfo.display.web.WebViewActivity;
import com.nishinonaru.devinfo.global.Const;

import java.util.ArrayList;
import java.util.List;

import static com.nishinonaru.devinfo.global.Util.checkNotNull;
import static com.nishinonaru.devinfo.global.Util.showImage;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements MainContract.View {

    private static final String TAG = "MainFragment";
    private RecyclerView mRecyclerView;
    private MainRvAdapter mMainRvAdapter;
    private MainPresenter mPresenter;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.start();
        }
    }

    public void replaceData(List<ShowItem> list) {
        mMainRvAdapter.replaceData(list);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        mMainRvAdapter = new MainRvAdapter(this.getActivity(), new ArrayList<ShowItem>(0), mItemListener);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.rvContent);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mRecyclerView.setAdapter(mMainRvAdapter);
    }

    @Override
    public void setPresenter(MainPresenter presenter) {
        mPresenter = presenter;
    }

    class MainRvAdapter extends RecyclerView.Adapter<MainRvAdapter.MainViewHolder> {

        private Context mContext;
        private List<ShowItem> mInfoList;
        private RvClickListener mListener;

        public MainRvAdapter(Context context, List<ShowItem> infoList, RvClickListener listener) {
            mContext = context;
            mListener = listener;
            setList(infoList);
        }

        private void setList(List<ShowItem> list) {
            mInfoList = new ArrayList<>(list);
        }

        void replaceData(List<ShowItem> list) {
            setList(list);
            notifyDataSetChanged();
        }

        @Override
        public MainRvAdapter.MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MainViewHolder holder = new MainViewHolder(LayoutInflater.from(mContext)
                    .inflate(R.layout.item_main_recyclerview, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MainRvAdapter.MainViewHolder holder, int position) {
            final ShowItem item = mInfoList.get(position);
            checkNotNull(item, "item can not be null in onBindViewHolder");
            holder.tvTitle.setText(item.getNewsTitle());
            showImage(mContext, item.getImgPath(), holder.ivHead);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemClick(item);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mInfoList.size();
        }

        class MainViewHolder extends RecyclerView.ViewHolder {

            TextView tvTitle;
            ImageView ivHead;

            public MainViewHolder(View itemView) {
                super(itemView);
                tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
                ivHead = (ImageView) itemView.findViewById(R.id.ivHead);
            }
        }
    }

    public interface RvClickListener {
        void onItemClick(ShowItem showItem);
    }

    RvClickListener mItemListener = new RvClickListener() {
        @Override
        public void onItemClick(ShowItem showItem) {
            Intent intent = new Intent(getActivity(), WebViewActivity.class);
            intent.putExtra(Const.SHOW_ITEM, showItem);
            startActivity(intent);
        }
    };
}
