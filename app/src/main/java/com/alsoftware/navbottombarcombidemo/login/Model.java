package com.alsoftware.navbottombarcombidemo.login;

import android.app.Application;

import com.alsoftware.navbottombarcombidemo.User;
import com.alsoftware.navbottombarcombidemo.login.api.LoginAPI;
import com.alsoftware.navbottombarcombidemo.login.api.WebAPI;

public class Model {

    private static OnLoginListener mListener;
    private Application mApplication;
    private LoginAPI mApi;
    private static Model sInstance = null;

    public User getUser() {
        return mUser;
    }

    public void setUser(User mUser) {
        this.mUser = mUser;
    }

    private User mUser;

    private Model(Application application) {
        mApplication = application;
        mApi = new WebAPI(mApplication);
    }

    public static Model getInstance(Application application) {
        if (sInstance == null) {
            sInstance = new Model(application);
        }
        return sInstance;
    }

    public Application getApplication() {
        return mApplication;
    }

    public void login(String email, String password, OnLoginListener loginListener) {
        mApi.login(email, password, loginListener);
    }
}