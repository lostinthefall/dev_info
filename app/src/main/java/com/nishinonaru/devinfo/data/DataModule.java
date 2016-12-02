package com.nishinonaru.devinfo.data;

/*
 * Created by 西野奈留NishinoNaru on 2016/12/2.
 */

import com.nishinonaru.devinfo.data.net.NewsItem;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Singleton
@Module
public class DataModule {

    @Provides
    NewsItem provideNewsItem() {
        return new NewsItem();
    }
}
