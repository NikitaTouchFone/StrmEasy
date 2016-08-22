package com.network.retrofit.rest.serviceinterface;

import com.network.NetworkConfig;
import com.network.model.MoreStatus;
import com.network.model.Status;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by nikita on 22/8/16.
 */
public interface MoreService {

    @GET(NetworkConfig.MORE_API)
    Call<MoreStatus> execMoreApiCall();

}
