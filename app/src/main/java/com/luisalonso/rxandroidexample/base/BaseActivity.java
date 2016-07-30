package com.luisalonso.rxandroidexample.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Create by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int getLayout();
    protected abstract void setupView(Bundle savedInstanceState);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        setupView(savedInstanceState);
    }

    protected void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    protected void showMessage(int res) {
        Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
    }
}
