package com.alsoftware.navbottombarcombidemo.login.api;

import android.app.Application;
import android.widget.Toast;

import com.alsoftware.navbottombarcombidemo.User;
import com.alsoftware.navbottombarcombidemo.login.OnLoginListener;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class WebAPI implements LoginAPI {

    private final Application mApplication;
    private String BASE_URL = "https://bngtvdemoapp.herokuapp.com/";
    private RequestQueue mRequestQueue;
    
    public WebAPI(Application application) {
        mApplication = application;
        mRequestQueue = Volley.newRequestQueue(application);
    }

    @Override
    public void login(String email, String password, OnLoginListener loginListener) {
        String url = BASE_URL + "api/users/login";
        JSONObject loginCredentials = new JSONObject();

        try {
            loginCredentials.put("email", email);
            loginCredentials.put("password", password);

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, loginCredentials,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                User user = User.getUser(response);
                                loginListener.onLogin(user);
                                Toast.makeText(mApplication, "Welcome Back!", Toast.LENGTH_SHORT).show();
                            } catch (JSONException e) {
                                Toast.makeText(mApplication, "JSON Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(mApplication, "Unable to login", Toast.LENGTH_SHORT).show();
                        }
                    });
            mRequestQueue.add(request);
        } catch (JSONException e) {
            Toast.makeText(mApplication, "JSON Error", Toast.LENGTH_SHORT).show();
        }
    }
}
