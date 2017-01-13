package com.mostafa_anter.amazinginsert.app;

import android.app.Application;
import android.content.Context;

import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by mostafa on 21/03/16.
 */
public class AppController extends Application {
    // for volley
    public static final String TAG = AppController.class
            .getSimpleName();

    private RequestQueue mRequestQueue;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    private static AppController mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        // to cash data :)
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        // for volley
        mInstance = this;
    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }


    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}