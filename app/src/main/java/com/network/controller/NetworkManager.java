package com.network.controller;

import android.content.Context;
import android.util.Log;

import com.network.retrofit.manager.RetrofitManager;
import com.network.subscriber.ResponseSubscriber;
import com.strmeasy.application.StrmEasyApplication;

/**
 * Singleton handling all requests made by the client app. Internally will delegate the requests
 * to an associated network library for handling actual requests and responses.
 * Created by nikita on 8/8/16.
 */
public class NetworkManager {

    private static NetworkManager nwManagerInstance = new NetworkManager();
    private LibraryContract library;

    private NetworkManager() {
        library = RetrofitManager.getInstance();
        library.init(StrmEasyApplication.getInstance());
    }

    public static NetworkManager getInstance() {
        return nwManagerInstance;
    }

    /*public void enqueueHomeApiRequest(String accessToken, String uid, ResponseSubscriber responseSubscriber) {
        library.executeHomeApiRequest(accessToken, uid, responseSubscriber);*/

    public void enqueueHomeApiRequest(ResponseSubscriber responseSubscriber) {
        library.executeHomeApiRequest(responseSubscriber);
    }

    public void enqueueSynopsisApiRequest(ResponseSubscriber responseSubscriber) {
        library.executeSynopsisApiRequest(responseSubscriber);
    }

    public void enqueueMoreApiRequest(ResponseSubscriber responseSubscriber) {
        library.executeMoreApiRequest(responseSubscriber);
    }

     /*public void removeAllCache(Context context) {
        library.removeAllCache(context);
    }

    public void removeCache(Context context, String url) {
        library.removeCache(context, url);
    }*/


}
