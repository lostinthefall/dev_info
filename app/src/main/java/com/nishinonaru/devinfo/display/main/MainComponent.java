package com.nishinonaru.devinfo.display.main;

import com.nishinonaru.devinfo.data.DataModule;

import javax.inject.Singleton;

import dagger.Component;

/*
 * Created by 西野奈留NishinoNaru on 2016/12/2.
 */
@Singleton
@Component(modules = {MainModule.class, DataModule.class})
public interface MainComponent {

    void inject(MainActivity ma);

}
