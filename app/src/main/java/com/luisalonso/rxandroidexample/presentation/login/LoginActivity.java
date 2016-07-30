package com.luisalonso.rxandroidexample.presentation.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;

import com.luisalonso.rxandroidexample.R;
import com.luisalonso.rxandroidexample.RxAndroidExample;
import com.luisalonso.rxandroidexample.base.BaseActivity;
import com.luisalonso.rxandroidexample.domain.User;
import com.luisalonso.rxandroidexample.presentation.contest.ContestActivity;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import rx.Observable;
import rx.Observer;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

/**
 * Create by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public class LoginActivity extends BaseActivity {

    @BindView(R.id.username_field) EditText mUsernameField;
    @BindView(R.id.password_field) EditText mPasswordField;
    @BindView(R.id.login_button) Button mLoginButton;

    private Observable<String> mUserNameFieldSubject;
    private Observable<String> mPasswordFieldSubject;
    private Observable<Object> mLoginButtonSubject;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void setupView(Bundle savedInstanceState) {
        mUserNameFieldSubject = BehaviorSubject.create(mUsernameField.getText().toString());
        mPasswordFieldSubject = BehaviorSubject.create(mPasswordField.getText().toString());
        mLoginButtonSubject = PublishSubject.create();

        Observable.combineLatest(mUserNameFieldSubject, mPasswordFieldSubject,
                new Func2<String, String, Boolean>() {
                    @Override
                    public Boolean call(String s, String s2) {
                        return !(s.isEmpty() || s2.isEmpty());
                    }
                }).subscribe(new Observer<Boolean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
                        mLoginButton.setEnabled(aBoolean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        if (e.getMessage() != null) {
                            RxAndroidExample.log(e.getMessage());
                        }
                    }
        });

        mLoginButtonSubject
                .flatMap(new Func1<Object, Observable<User>>() {
                    @Override
                    public Observable<User> call(Object o) {
                        return Observable.combineLatest(
                                mUserNameFieldSubject,
                                mPasswordFieldSubject,
                                new Func2<String, String, User>() {
                                    @Override
                                    public User call(String s, String s2) {
                                        return new User(s, s2);
                                    }
                                }
                        ).take(1);
                    }
                })
                .subscribe(new Action1<User>() {
                    @Override
                    public void call(User user) {
                        if (user.exist()) {
                            startActivity(new Intent(LoginActivity.this, ContestActivity.class));
                        } else {
                            showMessage(R.string.unsuccess_login_toast);
                        }
                    }
                });
    }

    @OnTextChanged(value = R.id.username_field, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void onAfterUserNameFieldTextChanged(Editable editable) {
        ((BehaviorSubject<String>) mUserNameFieldSubject).onNext(editable.toString());
    }

    @OnTextChanged(value = R.id.password_field, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void onAfterPasswordFieldTextChanged(Editable editable) {
        ((BehaviorSubject<String>) mPasswordFieldSubject).onNext(editable.toString());
    }

    @OnClick(value = R.id.login_button)
    void login() {
        ((PublishSubject<Object>) mLoginButtonSubject).onNext(new Object());
    }
}
