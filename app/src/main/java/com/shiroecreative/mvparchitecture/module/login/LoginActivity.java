package com.shiroecreative.mvparchitecture.module.login;

import android.view.View;

import com.shiroecreative.mvparchitecture.base.BaseFragmentHolderActivity;

public class LoginActivity extends BaseFragmentHolderActivity {

    LoginFragment loginFragment;

    @Override
    protected void initializeFragment() {
        initializeView();

        btnBack.setVisibility(View.GONE);
        btnOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.VISIBLE);

        loginFragment = new LoginFragment();
        setCurrentFragment(loginFragment, false);
    }
}
