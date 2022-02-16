package com.gender.gendercomfortable.controller.utills;

/*
 * Created by Nishant  Bhardwaj on 15-06-2017.
 */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;



public class App extends MultiDexApplication {
    private static App appInstance;
    private static com.gender.gendercomfortable.controller.utills.AppPreferences appPreferences;





    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        appInstance = this;
        appPreferences = com.gender.gendercomfortable.controller.utills.AppPreferences.init(appInstance);

    }



    public static App getAppContext() {
        return appInstance;

    }

    public static com.gender.gendercomfortable.controller.utills.AppPreferences getAppPreferences() {
        return appPreferences;
    }










}
