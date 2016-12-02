package com.nishinonaru.devinfo.data.entity;

/*
 * Created by 西野奈留NishinoNaru on 2016/12/2.
 */

/**
 * 在主页中展示的item
 */
public class ShowItem {

    private String newsTitle;
    private String imgPath;

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return " newsTitle= " + newsTitle
                + " imgPath= " + imgPath;
    }
}
