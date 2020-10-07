package com.shiroecreative.mvparchitecture.module.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;
import com.shiroecreative.mvparchitecture.R;
import com.shiroecreative.mvparchitecture.base.BaseFragment;
import com.shiroecreative.mvparchitecture.module.profile.ProfileActivity;

public class LoginFragment extends BaseFragment<LoginActivity, LoginContract.Presenter> implements LoginContract.View {

    private TextInputEditText etEmail;
    private TextInputEditText etPassword;
    private Button btnLogin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_login, container, false);
        presenter = new LoginPresenter(this, requireContext());
        presenter.start();

        etEmail = fragmentView.findViewById(R.id.et_email);
        etPassword = fragmentView.findViewById(R.id.et_password);
        btnLogin = fragmentView.findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this::setBtnLoginClick);

        setTitle(getResources().getString(R.string.login_title));

        return fragmentView;
    }

    private void setBtnLoginClick(View view) {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        presenter.performLogin(email, password);
    }

    @Override
    public void redirectToProfile() {
        Intent intent = new Intent(activity, ProfileActivity.class);
        startActivity(intent);
        activity.finish();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
