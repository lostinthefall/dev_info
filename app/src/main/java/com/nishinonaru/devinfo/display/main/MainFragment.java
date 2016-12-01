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
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;


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

    Document doc;

    private void testJsoup() {
        try {
            doc = Jsoup.connect(Const.ADDRESS_ANDROID_CHINA).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Map<String, String>> list = new ArrayList<>();
        Elements elements = doc.getElementsByClass("focus");
        for (Element e : elements) {
            Map<String, String> map = new Hashtable<>();
            map.put("title", e.getElementsByTag("a").select("img").attr("alt"));
            list.add(map);
        }
        for (Map<String, String> map : list) {
            Log.d(TAG, "testJsoup: " + map.get("title"));
        }
    }


}
