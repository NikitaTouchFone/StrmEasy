package com.strmeasy.helpers;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Point;
import android.location.Address;
import android.location.Geocoder;
import android.net.ConnectivityManager;
import android.provider.Settings;
import android.util.Log;
import android.view.Display;
import android.widget.Toast;


import java.io.File;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import com.strmeasy.R;
import com.strmeasy.activities.SplashScreen;
import com.strmeasy.sharedpref.StrmEasySharedPref;

public class Utils {

    public static boolean isInternetConnected(Context context) {

        try {
            ConnectivityManager connManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);

            return null != connManager.getActiveNetworkInfo() && connManager.getActiveNetworkInfo().isConnected();

        } catch (Exception e) {
            return false;
        }
    }


    public static String getDeviceImei(Context context) {
        if (null == ApplicationConstants.DEVICE_IMEI || ApplicationConstants.DEVICE_IMEI.equals("")) {
            try {
                ApplicationConstants.DEVICE_IMEI = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
                Log.e("Utils.java ", "getDeviceImei() ANDROID_IMEI_NO--" + ApplicationConstants.DEVICE_IMEI);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return ApplicationConstants.DEVICE_IMEI;
    }


        /*static void doLogin(String email, String password, final Context context) {
        NetworkManager.getInstance().enqueLoginApi(email, password, Utils.getDeviceImei(context), ErosPreferences.getCountryCode(context), ErosPreferences.getCity(context), new ResponseSubscriber() {

            Map<String, List<String>> nameValuePairs = null;

            @Override
            public void onSuccess(Object responseModel) {
                RegisterUserModel registerUserModel = (RegisterUserModel) responseModel;
                if (null != registerUserModel) {
                    if (registerUserModel.getSuccess()) {
                        if (null != nameValuePairs) {
                            try {
                                String hog_token = nameValuePairs.get(com.faythTv.helpers.ApplicationConstants.HOG_TOKEN_RESPONSE_HEADER).get(0);
                                ErosPreferences.setHogToken(context, hog_token);
                            } catch (Exception e) {
                                e.printStackTrace();
                                try {
                                    Crashlytics.logException(e);
                                } catch (Exception e1) {
                                    e.printStackTrace();
                                }
                            }

                            String accessToken = nameValuePairs.get(com.faythTv.helpers.ApplicationConstants.X_ACCESS_TOKEN_RESPONSE_HEADER).get(0);
                            Log.e("HOG", "Login Access token--" + accessToken);

                            ErosApplication.setAccessToken(accessToken);
                            ErosApplication.setUID(registerUserModel.getUid());
                            ErosApplication.setAnalyticsUrl(registerUserModel.getAnalyticsUrl());

                        }
                    }
                }

            }

            @Override
            public void onFailure(RestError restError) {

            }

            @Override
            public void onFailure(Throwable t) {

            }

            @Override
            public void onResponseHeaders(Map<String, List<String>> nameValuePairs) {
                this.nameValuePairs = nameValuePairs;
            }
        });
    }*/


    public static void showToastMessage(Context activityContext, String message) {
        try {
            Toast.makeText(activityContext, message,
                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void getCountry(GPSTracker gps, Context context) {
        double latitude = gps.getLatitude();
        double longitude = gps.getLongitude();

        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses != null && !addresses.isEmpty()) {
                StrmEasySharedPref.setCountryCode(context, addresses.get(0).getCountryCode());
            }
        } catch (Exception ignored) {
        }
    }
    public static void retryExitPopup(final Activity activity,
                                      boolean showRetry, String message) {
        if (activity == null || activity.isFinishing()) {
            return;
        }

        try {
            AlertDialog.Builder alertbox = new AlertDialog.Builder(activity);

            alertbox.setMessage(message);
            alertbox.setCancelable(false);
            if (showRetry) {
                alertbox.setPositiveButton(R.string.retry,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int arg1) {

                                dialog.dismiss();

                                if (activity != null && !activity.isFinishing()) {
                                    if (activity instanceof SplashScreen) {
                                        ((SplashScreen) activity).retry();
                                    }
                                }
                            }

                        });

                alertbox.setNegativeButton(R.string.exit,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int arg1) {
                                dialog.dismiss();
                                activity.finish();
                                System.exit(0);
                            }

                        });
            } else {
                alertbox.setPositiveButton(R.string.exit,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int arg1) {
                                dialog.dismiss();
                                activity.finish();
                                System.exit(0);
                            }

                        });

            }

            /**
             * if finish() on activity is already called by any chance then
             * check if context still exists before calling show() on alertbox
             * to avoid exception
             */
            if (activity.isFinishing() == false) {
                alertbox.show();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}