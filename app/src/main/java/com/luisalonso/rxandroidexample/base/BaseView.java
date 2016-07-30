package com.luisalonso.rxandroidexample.base;

import android.support.annotation.NonNull;

/**
 * Create by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public interface BaseView<T extends BasePresenter> {
    void setPresenter(@NonNull T presenter);
}
