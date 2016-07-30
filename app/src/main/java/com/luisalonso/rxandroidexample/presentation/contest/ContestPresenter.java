package com.luisalonso.rxandroidexample.presentation.contest;

import android.support.annotation.NonNull;

import com.luisalonso.rxandroidexample.RxAndroidExample;
import com.luisalonso.rxandroidexample.network.ContestService;
import com.luisalonso.rxandroidexample.network.ServiceFactory;
import com.luisalonso.rxandroidexample.network.model.ContestResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Create by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public class ContestPresenter implements ContestContract.Presenter, Callback<ContestResponse> {

    private final ContestContract.View mContestView;

    public ContestPresenter(@NonNull ContestContract.View contestView) {
        mContestView = contestView;
        mContestView.setPresenter(this);
    }

    @Override
    public void start() {
        getProblems();
    }

    @Override
    public void getProblems() {
        mContestView.startLoading();
        ServiceFactory.retrofitService(ContestService.class).getProblems().enqueue(this);
    }

    @Override
    public void onResponse(Call<ContestResponse> call, Response<ContestResponse> response) {
        mContestView.stopLoading();
        ContestResponse contestResponse = response.body();
        mContestView.showProblems(contestResponse.getProblems());
    }

    @Override
    public void onFailure(Call<ContestResponse> call, Throwable t) {
        mContestView.stopLoading();
        mContestView.showProblems(null);
    }
}
