package com.luisalonso.rxandroidexample.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Create by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public abstract class BaseFragment extends Fragment {

    protected Context CONTEXT;

    protected abstract int getLayout();
    protected abstract void setupView(Bundle savedInstaceState);

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        CONTEXT = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        if (view != null) {
            return view;
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        setupView(savedInstanceState);
    }

    protected void showMessage(String message) {
        ((BaseActivity) CONTEXT).showMessage(message);
    }

    protected void showMessage(int message) {
        ((BaseActivity) CONTEXT).showMessage(message);
    }
}
