package com.shiroecreative.mvparchitecture.module.login;

import com.shiroecreative.mvparchitecture.base.BasePresenter;
import com.shiroecreative.mvparchitecture.base.BaseView;

public interface LoginContract {
    interface View extends BaseView<Presenter> {
        void redirectToProfile();
    }

    interface Presenter extends BasePresenter {
        void performLogin(String email, String password);
    }
}
