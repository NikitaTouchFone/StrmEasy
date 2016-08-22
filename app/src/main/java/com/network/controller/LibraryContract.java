package com.network.controller;

import android.content.Context;

import com.network.subscriber.ResponseSubscriber;

/**
 * Contract which all networking libraries should abide to communicate with Server using their
 * underlying technology and provide API specific responses to the requester.
 * Created by nikita on 08/08/2016.
 */
public interface LibraryContract {

    /**
     * Initialize any library related statements here
     */
    void init(Context context);

    /**
     * Request and fetch basic details which are required to start  app.
     *          access token which we are getting from server response after successful login
     *                  a user id wich we can get from server response
     */
    //void executeHomeApiRequest(String accessToken, String uid,ResponseSubscriber homeApiSubscriber);

    void executeHomeApiRequest(ResponseSubscriber homeApiSubscriber);

    void executeSynopsisApiRequest(ResponseSubscriber synopsisApiSubscriber);

    void executeMoreApiRequest(ResponseSubscriber moreApiSubscriber);


}
