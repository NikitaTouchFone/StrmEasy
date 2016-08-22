package com.strmeasy.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.network.controller.NetworkManager;
import com.network.model.RestError;
import com.network.model.Status;
import com.network.model.SynopsisStatus;
import com.network.subscriber.ResponseSubscriber;
import com.strmeasy.R;
import com.strmeasy.helpers.ApplicationConstants;
import com.strmeasy.helpers.GPSTracker;
import com.strmeasy.helpers.Permissions;
import com.strmeasy.helpers.Utils;
import com.strmeasy.sharedpref.StrmEasySharedPref;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SplashScreen extends AppCompatActivity implements Animation.AnimationListener {

    ImageView animateImage;
    private Animation animFadeIn;
    private Animation animFadeOut;
    ArrayList<String> languageListArray;
    String deviceId;
    GPSTracker gps;
    String TAG = "SplashScreen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        animateImage = (ImageView) findViewById(R.id.animate);
        languageListArray = new ArrayList<String>();
        languageListArray.add("English");
        languageListArray.add("Hindi");
        languageListArray.add("Urdu");
        languageListArray.add("Gujarati");
        languageListArray.add("Punjabi");
        languageListArray.add("Telugu");
        languageListArray.add("Malyalam");
        languageListArray.add("Marathi");
        languageListArray.add("Bengali");


        animFadeIn = AnimationUtils.loadAnimation(this, R.anim.anim_fade_in);
        animFadeOut = AnimationUtils.loadAnimation(this, R.anim.anim_fade_out);

        homeApi();
        //synopsisApi();

    }

    private void synopsisApi()
    {
        NetworkManager.getInstance().enqueueSynopsisApiRequest(new ResponseSubscriber() {
            @Override
            public void onSuccess(Object responseModel) {
                if (null != responseModel) {

                    SynopsisStatus objSynopsisAPIModel = (SynopsisStatus) responseModel;
                    if (objSynopsisAPIModel.getSuccess())
                        try {
                            Log.e("SynopsisAPI", " Data[] size is ***** " + objSynopsisAPIModel.getData().size()  +
                                    "  \n Category Size is ****  " + objSynopsisAPIModel.getData().get(0).getCountries().size()+"  \n Category Title is ****  " + objSynopsisAPIModel.getData().get(0).getCategories().get(0).getTitle()+"  \n Genere Size ***  "+objSynopsisAPIModel.getData().get(0).getGenre().size());

                        } catch (Exception e) {
                            e.printStackTrace();
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

            }
        });
    }

    private void homeApi() {
        NetworkManager.getInstance().enqueueHomeApiRequest(new ResponseSubscriber() {
            @Override
            public void onSuccess(Object responseModel) {
                if (null != responseModel) {

                    Status objHomeAPIModel = (Status) responseModel;
                    if (objHomeAPIModel.getSuccess())
                        try {
                            Log.e("HomeApi", " Data[] size is ***** " + objHomeAPIModel.getData().size() + "  \n Title is ****  " + objHomeAPIModel.getData().get(0).getTitle() + " \n Sections[] size is **** " + objHomeAPIModel.getData().get(0).getSections().size()+" \n Sections Title ****  "+objHomeAPIModel.getData().get(0).getSections().get(0).getTitle()+"   \n Items[] size ****  "+objHomeAPIModel.getData().get(0).getSections().get(0).getItems().size()+" \n Title One ****  "+objHomeAPIModel.getData().get(0).getSections().get(0).getItems().get(0).getTitle()+"  \n Title Two ***  "+objHomeAPIModel.getData().get(0).getSections().get(0).getItems().get(1).getTitle());
                        } catch (Exception e) {
                            e.printStackTrace();
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

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //getDeviceId,getLocation and platform to pass it to assets api.
        Log.e(TAG, " getDeviceImei() ***************  " + Utils.getDeviceImei(this));

        Utils.getDeviceImei(this);

        //to get location we will need internet or gps connection.
        if (Utils.isInternetConnected(SplashScreen.this)) {

            if (!Permissions.isPermissionGranted(SplashScreen.this, Permissions.PERMISSIONS_REQUEST_READ_PHONE_STATE)) {
                Permissions.requestPermission(SplashScreen.this, Permissions.PERMISSIONS_REQUEST_READ_PHONE_STATE);
            } else {
                if (!Permissions.isPermissionGranted(SplashScreen.this, Permissions.PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION)) {
                    Permissions.requestPermission(SplashScreen.this, Permissions.PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
                } else {
                    getCountry();
                }
            }

        } else {
            Utils.retryExitPopup(SplashScreen.this, true, getResources().getString(R.string.no_internet_msg));
        }
    }

    void getCountry() {
        gps = new GPSTracker(SplashScreen.this);
        if (gps.canGetLocation()) {
            if (!gps.isNetworkEnabled) {
                //GPS only mode is enabled. As GPS don't work inside a building and location cannot
                // be read High Accuracy mode should be enabled
                gps.showSettingsAlert(SplashScreen.this);
            } else {
                Utils.getCountry(gps, SplashScreen.this);
                Log.w("Country Code", StrmEasySharedPref.getCountryCode(this));
                AssetsApi assets = new AssetsApi();
                assets.execute();
            }
        } else {
            // can't get location; GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gps.showSettingsAlert(SplashScreen.this);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ApplicationConstants.LOCATION_SETTINGS_INTERNET_REQUEST) {

            gps = new GPSTracker(SplashScreen.this);
            if (gps.canGetLocation()) {
                if (!gps.isNetworkEnabled) {
                    //GPS only mode is enabled. As GPS don't work inside a building and location cannot
                    // be read High Accuracy mode should be enabled
                    finishAffinity();
                    overridePendingTransition(R.anim.anim_fade_out, R.anim.anim_fade_in);
                    System.exit(0);
                } else {
                    Utils.getCountry(gps, SplashScreen.this);
                    //loadData();
                }
            } else {
                // can't get location; GPS or Network is not enabled
                finishAffinity();
                overridePendingTransition(R.anim.anim_fade_out, R.anim.anim_fade_in);
                System.exit(0);
            }
        }

    }

    public void retry() {
        if (Utils.isInternetConnected(this)) {
            getCountry();
        } else {
            Utils.retryExitPopup(SplashScreen.this, true, getResources().getString(R.string.no_internet_msg));
        }
    }

    private class AssetsApi extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            /*
            *In assets() api we will pass device imei no, location and platform and
            * from its response we have Assets class and userId which we stored to
            * StrmEasyApplication.setUserId().
            * */
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            animFadeIn.setAnimationListener(SplashScreen.this);
            animateImage.startAnimation(animFadeIn);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            /*
            *Here we have another api call register() where we have to pass userid and location using
            * StrmEasyApplication.getUserId() and StrmEasySharedPref.getCountryCode(this). which in response will give register class
            * */
            RegisterApi register = new RegisterApi();
            register.execute();

        }
    }

    private class RegisterApi extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            animateImage.clearAnimation();

            /*I was using dialog but the issue with dialog is i was not able to get
            the click listener of the recycler list and thus using activity as a dialog.
            */
            Intent intent = new Intent(SplashScreen.this, LanguageActivity.class);
            intent.putExtra("langArray", languageListArray);
            startActivity(intent);
        }
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == animFadeIn) {
            //animateImage.startAnimation(animFadeOut);
            //animateImage.startAnimation(animFadeIn);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case Permissions.PERMISSIONS_REQUEST_READ_PHONE_STATE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (!Permissions.isPermissionGranted(this, Permissions.PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION)) {
                        Permissions.requestPermission(SplashScreen.this, Permissions.PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
                    } else {
                        getCountry();
                    }
                } else {
                    // Handle deny selection by the user
                    showMessage("Oops! You didn't grant us necessary permission to proceed with the app.");
                }
                break;
            case Permissions.PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE:
                break;
            case Permissions.PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getCountry();
                } else {
                    // Handle deny selection by the user
                    showMessage("Oops! You didn't grant us necessary permission to proceed with the app.");
                }
                break;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    void showMessage(String errorMsg) {
        try {
            final AlertDialog.Builder alertbox = new AlertDialog.Builder(
                    SplashScreen.this);

            alertbox.setMessage(errorMsg);
            alertbox.setCancelable(false);
            alertbox.setPositiveButton(R.string.ok,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int arg1) {
                            dialog.dismiss();
                            finish();
                        }

                    });
            /**
             * if finish() on activity is already called by any chance then
             * check if context still exists before calling show() on
             * alertbox to avoid exception
             */
            if (SplashScreen.this.isFinishing() == false) {
                alertbox.show();
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
}