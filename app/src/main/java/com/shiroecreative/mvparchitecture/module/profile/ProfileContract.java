package com.shiroecreative.mvparchitecture.module.profile;

import com.shiroecreative.mvparchitecture.base.BasePresenter;
import com.shiroecreative.mvparchitecture.base.BaseView;

public interface ProfileContract {
    interface View extends BaseView<Presenter> {
        void goBackToLogin();

        void updateProfile(String email, String password);
    }

    interface Presenter extends BasePresenter {
        void getProfile();
    }
}
