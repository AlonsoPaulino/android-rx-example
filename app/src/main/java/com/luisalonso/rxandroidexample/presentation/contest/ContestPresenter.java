package com.luisalonso.rxandroidexample.presentation.contest;

import android.support.annotation.NonNull;

import com.luisalonso.rxandroidexample.RxAndroidExample;
import com.luisalonso.rxandroidexample.network.ContestService;
import com.luisalonso.rxandroidexample.network.ServiceFactory;
import com.luisalonso.rxandroidexample.network.model.ContestResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Create by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public class ContestPresenter implements ContestContract.Presenter{

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
        ServiceFactory.retrofitService(ContestService.class).getProblems()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ContestResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mContestView.stopLoading();
                        e.printStackTrace();
                        if (e.getMessage() != null) {
                            RxAndroidExample.log(e.getMessage());
                        }
                        mContestView.showProblems(null);
                    }

                    @Override
                    public void onNext(ContestResponse contestResponse) {
                        mContestView.stopLoading();
                        mContestView.showProblems(contestResponse.getProblems());
                    }
                });
    }
}
