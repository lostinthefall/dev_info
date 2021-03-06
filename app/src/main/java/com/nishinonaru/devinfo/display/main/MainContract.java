package com.nishinonaru.devinfo.display.main;

/*
 * Created by 西野奈留NishinoNaru on 2016/12/2.
 */

public interface MainContract {

    interface View {
        void setPresenter(MainPresenter presenter);
    }

    interface Presenter {
        void start();
    }
}
