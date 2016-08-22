package com.strmeasy.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

/**
 * Created by nikita on 18/7/16.
 * This class is there to store a variable beyond the lifetime of the application that is running.
 * So for example it could be user Color  preference for the application that remains same until
 * the user changes it again or  if the app is uninstalled.
 */
public class StrmEasySharedPref {

    private static final String KEY = "strmeasy.prefs";
    private static final String COUNTRY_CODE = "countrycode";
    private static final String SELECTED_LANG = "selected_language";
    private static ArrayList<String> selectedLang;

    // countryCode
    public static void setCountryCode(Context context, String countryCode) {
        SharedPreferences.Editor editor = context.getSharedPreferences(KEY, Context.MODE_PRIVATE).edit();
        editor.putString(COUNTRY_CODE, countryCode);
        editor.commit();
    }

    // countryCode
    public static String getCountryCode(Context context) {
        SharedPreferences savedSession = context.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        return savedSession.getString(COUNTRY_CODE, "");
    }

    /*public void setSelectedLang(Context context,ArrayList<String> langArray)
    {
        SharedPreferences.Editor editor = context.getSharedPreferences(KEY, Context.MODE_PRIVATE).edit();
        editor.putStringSet(COUNTRY_CODE, countryCode);
        editor.commit();
        selectedLang = new ArrayList<String>();
        selectedLang = langArray;
    }

    public ArrayList<String> getSelectedLang(Context context)
    {
        return  selectedLang;
    }*/


}
