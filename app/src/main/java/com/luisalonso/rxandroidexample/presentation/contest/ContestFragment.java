package com.luisalonso.rxandroidexample.presentation.contest;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.luisalonso.rxandroidexample.R;
import com.luisalonso.rxandroidexample.base.BaseFragment;
import com.luisalonso.rxandroidexample.domain.Problem;

import java.util.List;

import butterknife.BindView;

/**
 * Create by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public class ContestFragment extends BaseFragment implements ContestContract.View{

    @BindView(R.id.problems_list_view) RecyclerView mProblemsListView;

    private ProgressDialog mProgress;
    private ContestContract.Presenter mPresenter;

    public static ContestFragment newInstance() {
        return new ContestFragment();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_problems;
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.start();
    }

    @Override
    protected void setupView(Bundle savedInstaceState) {

    }

    @Override
    public void setPresenter(@NonNull ContestContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showProblems(List<Problem> problems) {
        if (problems != null) {
            mProblemsListView.setLayoutManager(new LinearLayoutManager(CONTEXT));
            mProblemsListView.setAdapter(new ContestAdapter(problems));
        } else {
            showMessage(R.string.network_error);
        }
    }

    @Override
    public void startLoading() {
        if (mProgress == null) {
            mProgress = new ProgressDialog(CONTEXT);
        }
        mProgress.show();
    }

    @Override
    public void stopLoading() {
        if (mProgress != null) {
            mProgress.dismiss();
        }
    }
}
