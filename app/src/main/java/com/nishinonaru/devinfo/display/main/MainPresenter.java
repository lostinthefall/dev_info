package com.nishinonaru.devinfo.display.main;

/*
 * Created by 西野奈留NishinoNaru on 2016/12/2.
 */

import android.os.AsyncTask;
import android.util.Log;

import com.nishinonaru.devinfo.data.entity.ShowItem;
import com.nishinonaru.devinfo.data.net.NewsItem;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {

    private MainFragment mFragment;
    private static final String TAG = "MainPresenter";

    NewsItem mNewsItem;

    public MainPresenter(MainFragment mf, NewsItem item) {
        mFragment = mf;
        mNewsItem = item;
        mFragment.setPresenter(this);
    }

    @Override
    public void start() {
        loadInfos();
    }

    private void loadInfos() {
        new AsyncTask<Void, Void, List<ShowItem>>() {
            @Override
            protected List<ShowItem> doInBackground(Void... voids) {
                return mNewsItem.getItems();
            }

            @Override
            protected void onPostExecute(List<ShowItem> items) {
                mFragment.replaceData(items);
                Log.d(TAG, "onPostExecute: " + items.toString());
            }
        }.execute();
    }
}
