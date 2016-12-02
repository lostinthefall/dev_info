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
        Elements elements = doc.getElementsByClass("focus");
        for (Element e : elements) {
            ShowItem item = new ShowItem();
            item.setNewsTitle(e.getElementsByTag("a").select("img").attr("alt"));
            item.setImgPath(e.getElementsByTag("a").select("img").attr("src"));
            Log.d(TAG, "getItems: " + item);
            list.add(item);
        }
        return list;
    }
}
