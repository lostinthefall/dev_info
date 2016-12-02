package com.nishinonaru.devinfo.global;

/*
 * Created by 西野奈留NishinoNaru on 2016/12/2.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Util {

    public static <T> T checkNotNull(T object, String message) {
        if (object == null) {
            throw new NullPointerException(message);
        }
        return object;
    }

    public static void showImage(@NonNull Context context, @NonNull String url,
                                 @NonNull ImageView iv) {
        Glide.with(context).load(url).centerCrop().into(iv);
    }

}
