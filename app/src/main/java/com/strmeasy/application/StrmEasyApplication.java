package com.strmeasy.application;

import android.app.Application;
import android.support.multidex.MultiDexApplication;

/**
 * Created by nikita on 13/7/16.
 * This class have those constants for which we get the value form response for eg. from assets() api we are getting userId
 * which can be set here as a setter and can be use as a getter.
 */
public class StrmEasyApplication extends Application {

    public static StrmEasyApplication sEasyInstance;

    public static String userId;

    public static StrmEasyApplication getInstance()
    {
        if(sEasyInstance == null)
            sEasyInstance = new StrmEasyApplication();
        return  sEasyInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sEasyInstance = this;
    }

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String UID)
    {
        userId = UID;
    }

}
