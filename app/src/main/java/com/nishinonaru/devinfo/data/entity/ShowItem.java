package com.nishinonaru.devinfo.data.entity;

/*
 * Created by 西野奈留NishinoNaru on 2016/12/2.
 */

import java.io.Serializable;

/**
 * 在主页中展示的item
 */
public class ShowItem implements Serializable {

    /**
     * title of the article
     */
    private String newsTitle;
    /**
     * the address of the head image
     */
    private String imgPath;
    /**
     * the address of the article
     */
    private String articlePath;

    public String getArticlePath() {
        return articlePath;
    }

    public void setArticlePath(String articlePath) {
        this.articlePath = articlePath;
    }

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
                + " imgPath= " + imgPath
                + " articlePath= " + articlePath
                ;
    }
}
