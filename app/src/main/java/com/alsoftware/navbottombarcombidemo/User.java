package com.alsoftware.navbottombarcombidemo;

import org.json.JSONException;
import org.json.JSONObject;

public class User {
    private String username;
    private String email;
    private String token;

    public static User getUser(JSONObject jsonObject) throws JSONException {
        String username = jsonObject.getString("username");
        String email = jsonObject.getString("email");
        String token = jsonObject.getString("token");

        return new User(username, email, token);
    }

    public User(String username, String email, String token) {
        this.username = username;
        this.email = email;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        if (obj != null && obj instanceof User) {
            User that = (User) obj;

            if (this.email.equalsIgnoreCase(that.email)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
