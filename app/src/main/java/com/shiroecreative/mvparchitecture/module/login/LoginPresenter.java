package com.shiroecreative.mvparchitecture.module.login;

import android.content.Context;
import android.content.SharedPreferences;

import static com.shiroecreative.mvparchitecture.Constants.EMAIL_KEY;
import static com.shiroecreative.mvparchitecture.Constants.PASSWORD_KEY;
import static com.shiroecreative.mvparchitecture.Constants.PREFERENCE_KEY;

public class LoginPresenter implements LoginContract.Presenter {

    private final LoginContract.View view;
    private final SharedPreferences sharedPreferences;

    public LoginPresenter(LoginContract.View view, Context context) {
        this.sharedPreferences = context.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE);
        this.view = view;
    }

    @Override
    public void performLogin(String email, String password) {
        // This is not the way
        // Cause it isn't SRP
        saveUser(email, password);
        view.redirectToProfile();
    }

    @Override
    public void start() {

    }

    private void saveUser(String email, String password) {
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.putString(EMAIL_KEY, email);
        editor.putString(PASSWORD_KEY, password);
        editor.commit();
    }
}
