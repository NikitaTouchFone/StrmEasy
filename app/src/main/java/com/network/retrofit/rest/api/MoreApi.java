package com.network.retrofit.rest.api;

import com.network.retrofit.manager.RetrofitManager;
import com.network.retrofit.rest.serviceinterface.HomeService;
import com.network.retrofit.rest.serviceinterface.MoreService;
import com.network.subscriber.ResponseSubscriber;

/**
 * Created by nikita on 22/8/16.
 */
public class MoreApi extends RestApi {

    private static final MoreService service = RetrofitManager.getInstance()
            .getRetrofitClient().create(MoreService.class);

    public MoreApi(ResponseSubscriber subscriber) {
        super(subscriber);
        ResponseSubscriber moreApiResponseSubscriber = subscriber;
        client = service.execMoreApiCall();
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
