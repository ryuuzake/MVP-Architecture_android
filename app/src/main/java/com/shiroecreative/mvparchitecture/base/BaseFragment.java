package com.shiroecreative.mvparchitecture.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.shiroecreative.mvparchitecture.R;

public abstract class BaseFragment<T extends FragmentActivity, U extends BasePresenter> extends Fragment {

    protected String title;
    protected T activity;
    protected View fragmentView;
    protected U presenter;
    protected FragmentListener fragmentListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        title = getResources().getString(R.string.app_name);
        setTitle(title);

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.activity = (T) context;
        this.fragmentListener = (FragmentListener) context;
    }

    protected void setTitle(String title) {
        this.title = title;
        fragmentListener.setTitle(title);
    }

    public String getTitle() {
        return title;
    }
}
