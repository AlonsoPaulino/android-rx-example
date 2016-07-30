package com.luisalonso.rxandroidexample.network;

import com.luisalonso.rxandroidexample.network.model.ContestResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Create by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public interface ContestService {

    @GET("problemset.problems?tags=graphs")
    Observable<ContestResponse> getProblems();
}
