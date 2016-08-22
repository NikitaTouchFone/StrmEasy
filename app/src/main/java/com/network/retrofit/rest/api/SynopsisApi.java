package com.network.retrofit.rest.api;

import com.network.retrofit.manager.RetrofitManager;
import com.network.retrofit.rest.serviceinterface.HomeService;
import com.network.retrofit.rest.serviceinterface.SynopsisService;
import com.network.subscriber.ResponseSubscriber;

/**
 * Created by nikita on 17/8/16.
 */
public class SynopsisApi extends RestApi {

    private static final SynopsisService service = RetrofitManager.getInstance()
            .getRetrofitClient().create(SynopsisService.class);

    public SynopsisApi(ResponseSubscriber subscriber) {
        super(subscriber);
        ResponseSubscriber synopsisApiResponseSubscriber = subscriber;
        client = service.execSynopsisApiCall();
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
