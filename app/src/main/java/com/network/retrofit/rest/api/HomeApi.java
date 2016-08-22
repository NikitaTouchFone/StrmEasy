package com.network.retrofit.rest.api;


import android.util.Log;

import com.network.retrofit.manager.RetrofitManager;
import com.network.retrofit.rest.serviceinterface.HomeService;
import com.network.subscriber.ResponseSubscriber;

public class HomeApi extends RestApi {

    private static final HomeService service = RetrofitManager.getInstance()
            .getRetrofitClient().create(HomeService.class);

    /*public HomeApi(ResponseSubscriber subscriber, String uid, String accessToken) {
        super(subscriber);
        String uid1 = uid;
        String accessToken1 = accessToken;
        ResponseSubscriber homeApiResponseSubscriber = subscriber;
        client = service.execHomeApiCall(accessToken, uid);
    }*/

    public HomeApi(ResponseSubscriber subscriber) {
        super(subscriber);
        //String uid1 = uid;
        //String accessToken1 = accessToken;
        ResponseSubscriber homeApiResponseSubscriber = subscriber;
        client = service.execHomeApiCall();
    }

    public void cancel() {
        super.cancel();
    }

    public void retry() {
        super.retry();
        enqueueRequest();
    }

    @Override
    public void enqueueRequest() {
        super.enqueueRequest();
    }
}


