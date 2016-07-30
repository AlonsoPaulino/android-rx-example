package com.luisalonso.rxandroidexample.presentation.contest;

import com.luisalonso.rxandroidexample.base.BasePresenter;
import com.luisalonso.rxandroidexample.base.BaseView;
import com.luisalonso.rxandroidexample.domain.Problem;

import java.util.List;

/**
 * Create by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public class ContestContract {

    interface View extends BaseView<Presenter> {
        void showProblems(List<Problem> problems);
        void startLoading();
        void stopLoading();
    }

    interface Presenter extends BasePresenter {
        void getProblems();
    }
}
