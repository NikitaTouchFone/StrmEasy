package com.strmeasy.helpers;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;

import com.strmeasy.R;


/**
 * Created by nikita on 20/07/2016.
 */
public class Permissions {

    public static final int PERMISSIONS_REQUEST_READ_PHONE_STATE = 0;
    public static final int PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1;
    public static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 2;
    private static final String[] PERMISSIONS_MANIFEST;

    static {
        PERMISSIONS_MANIFEST = new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION};
    }

    //This is for runtime permission and introduced in Android-M
    public static boolean isPermissionGranted(Activity activityContext, int permissionCode) {
        return ContextCompat.checkSelfPermission(activityContext, getManifestPermission(permissionCode)) == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestPermission(Activity activityContext, int permissionCode) {

        switch (permissionCode) {
            case PERMISSIONS_REQUEST_READ_PHONE_STATE:
                handlePermissionRequest(activityContext, permissionCode);
                break;
            case PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE:
                handlePermissionRequest(activityContext, permissionCode);
                break;
            case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION:
                handlePermissionRequest(activityContext, permissionCode);
                break;
        }
    }


    private static String getManifestPermission(int permissionCode) {
        return PERMISSIONS_MANIFEST[permissionCode];
    }


    private static void handlePermissionRequest(final Activity activityContext, final int permissionCode) {
        final String permissionString = getManifestPermission(permissionCode);
        if (ActivityCompat.shouldShowRequestPermissionRationale(activityContext, permissionString)) {
            // Show a brief description to the user detailing the need for requesting a particular permission
            String message = "";
            switch (permissionCode) {
                case PERMISSIONS_REQUEST_READ_PHONE_STATE:
                    message = activityContext.getResources().getString(R.string.description_read_phone_state);
                    break;
                case PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE:
                    message = activityContext.getResources().getString(R.string.description_write_external_storage);
                    break;
                case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION:
                    message = activityContext.getResources().getString(R.string.description_fine_location);
                    break;
            }
            new AlertDialog.Builder(activityContext)
                    .setMessage(message)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            ActivityCompat
                                    .requestPermissions(activityContext, new String[]{permissionString}, permissionCode);
                        }
                    }).show();


        } else {
            // The description is not needed, go ahead and request the permission. This is an asynchronous call, handle the result in the permissions callback
            ActivityCompat.requestPermissions(activityContext, new String[]{permissionString}, permissionCode);
        }
    }

}
