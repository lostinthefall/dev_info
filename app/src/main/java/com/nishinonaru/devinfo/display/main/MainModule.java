package com.nishinonaru.devinfo.display.main;

/*
 * Created by 西野奈留NishinoNaru on 2016/12/2.
 */

import com.nishinonaru.devinfo.data.net.NewsItem;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Singleton
    @Provides
    MainPresenter provideMainPresenter(MainFragment mf, NewsItem ni) {
        return new MainPresenter(mf, ni);
    }

    @Singleton
    @Provides
    MainFragment provideMainFragment() {
        return new MainFragment();
    }


}
