package com.nishinonaru.devinfo.data.net;

/*
 * Created by 西野奈留NishinoNaru on 2016/12/2.
 */

import android.util.Log;

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

import static android.content.ContentValues.TAG;

public class NewsItem {

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
