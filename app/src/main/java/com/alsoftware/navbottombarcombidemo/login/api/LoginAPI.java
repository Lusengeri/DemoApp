package com.alsoftware.navbottombarcombidemo.login.api;

import com.alsoftware.navbottombarcombidemo.login.OnLoginListener;

public interface LoginAPI {
    void login(String username, String password, OnLoginListener loginListener);
}
