package com.luisalonso.rxandroidexample.network;

import retrofit2.Retrofit;

/**
 * Create by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public final class ServiceFactory {

    /** This method will create a retrofit service **/
    public static <T> T retrofitService(final Class<T> tClass) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .build();
        return retrofit.create(tClass);
    }
}
