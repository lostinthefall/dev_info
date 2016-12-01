package com.nishinonaru.devinfo.display.main;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nishinonaru.devinfo.R;
import com.nishinonaru.devinfo.global.Const;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private static final String TAG = "MainFragment";

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

        //startActivity(new Intent(getActivity(), WebViewActivity.class));


        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                testJsoup();
                return null;
            }
        }.execute();


        return v;
    }

    private void testJsoup() {
        try {
            Document doc = Jsoup.connect(Const.ADDRESS_ANDROID_CHINA).get();
            Elements elements = doc.select("div.focus");
            Log.d(TAG, "testJsoup: " + elements.select("a").attr("href"));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
