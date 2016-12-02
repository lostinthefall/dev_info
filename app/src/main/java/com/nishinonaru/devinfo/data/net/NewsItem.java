package com.nishinonaru.devinfo.data.net;

/*
 * Created by 西野奈留NishinoNaru on 2016/12/2.
 */

import android.util.Log;

import com.nishinonaru.devinfo.data.entity.ShowItem;
import com.nishinonaru.devinfo.global.Const;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewsItem {

    private Document doc;
    private static final String TAG = "NewsItem";

    public List<ShowItem> getItems() {
        try {
            doc = Jsoup.connect(Const.ADDRESS_ANDROID_CHINA).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<ShowItem> list = new ArrayList<>();
        Elements elements = doc.getElementsByClass("excerpt");
        for (Element e : elements) {
            ShowItem item = new ShowItem();
            item.setArticlePath(e.getElementsByTag("header").select("h2").select("a").attr("href"));
            item.setImgPath(e.getElementsByTag("div").select("a").select("img").attr("src"));
            // label label-important
            item.setNewsTitle(e.getElementsByTag("header").select("h2").select("a").text());
            Log.d(TAG, "getItems: " + item.toString());
            list.add(item);
        }


        return list;
    }
}