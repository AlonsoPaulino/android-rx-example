package com.luisalonso.rxandroidexample.presentation.contest;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.luisalonso.rxandroidexample.R;
import com.luisalonso.rxandroidexample.base.BaseActivity;
import com.luisalonso.rxandroidexample.util.ActivityUtils;

/**
 * Create by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public class ContestActivity extends BaseActivity{

    @Override
    protected int getLayout() {
        return R.layout.activity_contest;
    }

    @Override
    protected void setupView(Bundle savedInstanceState) {
        FragmentManager manager = getSupportFragmentManager();
        ContestFragment fragment = (ContestFragment) manager.findFragmentById(R.id.contest_fragment_content);
        if (fragment == null) {
            fragment = ContestFragment.newInstance();
            ActivityUtils.addFragmentToActivity(manager, fragment, R.id.contest_fragment_content);
        }
        new ContestPresenter(fragment);
    }
}
